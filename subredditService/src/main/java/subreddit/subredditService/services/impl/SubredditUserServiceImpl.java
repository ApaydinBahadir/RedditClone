package subreddit.subredditService.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import subreddit.subredditService.core.utilities.results.DataResult;
import subreddit.subredditService.core.utilities.results.Result;
import subreddit.subredditService.dataAccess.SubredditDao;
import subreddit.subredditService.dataAccess.SubredditUserDao;
import subreddit.subredditService.entity.Subreddit;
import subreddit.subredditService.entity.SubredditUser;
import subreddit.subredditService.entity.SubredditUserId;
import subreddit.subredditService.services.SubredditUserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubredditUserServiceImpl implements SubredditUserService {
    private SubredditUserDao subredditUserDao;
    private SubredditDao subredditDao;
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public SubredditUserServiceImpl(SubredditUserDao subredditUserDao,SubredditDao subredditDao){
        super();
        this.subredditUserDao = subredditUserDao;
        this.subredditDao = subredditDao;
    }
    @Override
    public Result subscribe(int userId,int subredditId) {
        subredditUserDao.save(SubredditUser.builder()
                .role(1)
                .joinedat(LocalDateTime.now())
                .subredditUserId(new SubredditUserId(userId,subredditId))
                .build());
        return new Result(true,"Subreddit Subscribed");
    }

    @Override
    public Result updateRole(int subredditId, int userId,int role) {
        SubredditUser subreddituser = subredditUserDao.findByUserIdAndSubredditId(subredditId,userId);
        subreddituser.setRole(role);
        return new Result(true,"Role Updated");
    }

    @Override
    public Result unsubscribe(int subredditId, int userId) {
        subredditUserDao.deleteUserIdAndSubredditId(subredditId,userId);

        return new Result(true,"Subreddit Unsubscribed");
    }

    @Override
    public DataResult getUsersSubreddit(int userid) {

        List<Subreddit> arr = new ArrayList<>();

        for(int var: subredditUserDao.findSubredditByUserId(userid)){
            arr.addAll(subredditDao.findSubredditByUserId(var));
        }



        return new DataResult(arr, true,"Subreddit Listed");
    }


}
