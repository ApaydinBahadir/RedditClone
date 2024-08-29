package postservice.postservice.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import postservice.postservice.core.utilities.results.DataResult;
import postservice.postservice.core.utilities.results.Result;
import postservice.postservice.entitites.dtos.PostSaveRequest;
import postservice.postservice.services.PostService;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/api/post")
@CrossOrigin
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        super();
        this.postService = postService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody PostSaveRequest postSaveRequest){
        return postService.add(postSaveRequest);
    }

    @GetMapping("/user")
    public DataResult findByUser(@RequestParam Integer userId){
        return postService.findByUser(userId);
    }

    @GetMapping("/subreddit")
    public DataResult findBySubreddit(@RequestParam Integer subredditId){
        return postService.findBySubreddit(subredditId);
    }

    @GetMapping("/getPost")
    public DataResult getPost(@RequestParam Integer postId){
        return postService.findByPostId(postId);
    }

}
