package subreddit.subredditService.services;

import subreddit.subredditService.core.utilities.results.DataResult;
import subreddit.subredditService.core.utilities.results.Result;

import javax.xml.crypto.Data;
import java.util.List;

public interface SubredditUserService {
    Result subscribe(int subredditId, int userId);

    Result updateRole(int subredditId, int userId, int role);

    Result unsubscribe(int subredditId, int userId);

    List MainLatestPosts(int userid);

    DataResult getUsersSubreddit(int userid);
}
