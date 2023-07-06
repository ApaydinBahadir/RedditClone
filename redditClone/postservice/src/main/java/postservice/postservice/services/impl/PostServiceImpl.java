package postservice.postservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import postservice.postservice.core.utilities.PostSortingComparator;
import postservice.postservice.core.utilities.results.DataResult;
import postservice.postservice.core.utilities.results.Result;
import postservice.postservice.dataAccess.PostDao;
import postservice.postservice.entitites.Post;
import postservice.postservice.entitites.dtos.PostSaveRequest;
import postservice.postservice.services.PostService;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PostServiceImpl implements PostService {

    private PostDao postDao;
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public PostServiceImpl(PostDao postDao){
        super();
        this.postDao = postDao;
    }

    @Override
    public Result add(PostSaveRequest postSaveRequest) {
        postDao.save(Post.builder()
                        .userid(postSaveRequest.userid())
                        .title(postSaveRequest.title())
                        .created_at(LocalDateTime.now())
                        .post_text(postSaveRequest.post_text())
                        .subreddit(postSaveRequest.subreddit())
                .build());
        return new Result(true,"User saved");
    }

    @Override
    public DataResult<List<Integer>> findByUser(Integer userId) {
        return new DataResult(postDao.findByUserid(userId),true,"Post Listed");
    }

    @Override
    public DataResult<List<Integer>> findBySubreddit(Integer subredditId) {
        return new DataResult(postDao.findBySubreddit(subredditId),true,"Post Listed");
    }

    @Override
    public List MainLatestPosts(List<Integer> subredditList) {
        List<Post> arr = new ArrayList<>();
        for(int var: subredditList){
            arr.addAll(postDao.findBySubreddit(var));
        }
        arr.sort(Comparator.comparing(Post::getCreated_at).reversed());

        return arr;
    }

    @Override
    public DataResult findByPostId(Integer postId) {
        return new DataResult(postDao.getByPostId(postId),true,"Post Listed");
    }

}
