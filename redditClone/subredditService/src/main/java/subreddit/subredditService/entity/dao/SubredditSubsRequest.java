package subreddit.subredditService.entity.dao;

import subreddit.subredditService.entity.SubredditUserId;

public record SubredditSubsRequest(SubredditUserId subredditUserId){
    @Override
    public SubredditUserId subredditUserId() {
        return subredditUserId;
    }
}
