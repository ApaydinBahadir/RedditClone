package postservice.postservice.services;

import postservice.postservice.core.utilities.results.DataResult;
import postservice.postservice.core.utilities.results.Result;
import postservice.postservice.entitites.dtos.PostSaveRequest;

import java.util.List;

public interface PostService {
    Result add(PostSaveRequest postSaveRequest);
    DataResult<List<Integer>> findByUser(Integer userId);
    DataResult<List<Integer>> findBySubreddit(Integer subredditId);
    DataResult findByPostId(Integer postId);
}
