package subreddit.subredditService.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import subreddit.subredditService.core.utilities.results.DataResult;
import subreddit.subredditService.core.utilities.results.Result;
import subreddit.subredditService.dataAccess.SubredditDao;
import subreddit.subredditService.entity.Subreddit;
import subreddit.subredditService.entity.dao.SubredditSaveRequest;
import subreddit.subredditService.services.SubredditService;

import java.time.LocalDateTime;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
@Service
public class SubredditServiceImpl implements SubredditService {

    private SubredditDao subredditDao;
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    public SubredditServiceImpl(SubredditDao subredditDao){
        super();
        this.subredditDao = subredditDao;
    }

    @Override
    public Result add(SubredditSaveRequest subreddit) {
        subredditDao.save(Subreddit.builder()
                .name(subreddit.name())
                .about(subreddit.about())
                .createdAt(LocalDateTime.now())
                .build());
        return new Result(true,"Subreddit Created");

    }

    @Override
    public DataResult<List<String>> findByName(String name) {
        return new DataResult(subredditDao.getByNameStartsWith(name),true,"Subreddit Listed");
    }

    @Override
    public DataResult getById(int subredditId) {
        return new DataResult(subredditDao.findPostsBySubredditId(subredditId),true,"Subreddit Listed");
    }

}
