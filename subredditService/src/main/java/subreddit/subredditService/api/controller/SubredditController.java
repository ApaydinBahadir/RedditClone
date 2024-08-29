package subreddit.subredditService.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import subreddit.subredditService.core.utilities.results.DataResult;
import subreddit.subredditService.core.utilities.results.Result;
import subreddit.subredditService.entity.SubredditUserId;
import subreddit.subredditService.entity.dao.SubredditSaveRequest;
import subreddit.subredditService.entity.dao.SubredditSubsRequest;
import subreddit.subredditService.services.SubredditService;
import subreddit.subredditService.services.SubredditUserService;

import java.util.List;

@RestController
@RequestMapping("/api/subreddit")
public class SubredditController {
    private SubredditService subredditService;
    private SubredditUserService subredditUserService;

    @Autowired
    public SubredditController(SubredditService subredditService, SubredditUserService subredditUserService){
        this.subredditService = subredditService;
        this.subredditUserService = subredditUserService;

    }

    @PostMapping("/create")
    public Result createSubreddit(@RequestBody SubredditSaveRequest saveRequest){
        return subredditService.add(saveRequest);
    }

    @GetMapping("/subreddit")
    public DataResult getByName(@RequestParam String name){
        return subredditService.findByName(name);
    }

    @PostMapping("/subreddit/updateRole")
    public Result updateRole(@RequestParam int subredditId, int userId, int role){
        return subredditUserService.updateRole(subredditId,userId,role);
    }

    @GetMapping("/subredditUser/subscribe")
    public Result subscribe(@RequestParam int userId, int subredditId){
        return subredditUserService.subscribe(userId,subredditId);
    }

    @GetMapping("/subreddit/unsubscribe")
    public Result unsubscribe(@RequestParam int subredditId, int userId){
        return subredditUserService.unsubscribe(subredditId,userId);
    }

    @GetMapping("/subreddit/getById")
    public DataResult getById(@RequestParam int subredditId){
        return subredditService.getById(subredditId);
    }

    @GetMapping("/subreddit/getUsersSubreddit")
    public DataResult getUsersSubreddit(@RequestParam int userid){
        return subredditUserService.getUsersSubreddit(userid);
    }

}
