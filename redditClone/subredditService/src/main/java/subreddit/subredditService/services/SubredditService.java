package subreddit.subredditService.services;

import subreddit.subredditService.core.utilities.results.DataResult;
import subreddit.subredditService.core.utilities.results.Result;
import subreddit.subredditService.entity.dao.SubredditSaveRequest;

import java.util.List;

public interface SubredditService {
    Result add(SubredditSaveRequest subreddit);
    DataResult<List<String>> findByName(String name);
    DataResult getById(int subredditId);
}
