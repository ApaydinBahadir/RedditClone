package commentservice.commentservice.api.controller;

import commentservice.commentservice.core.utilities.results.DataResult;
import commentservice.commentservice.core.utilities.results.Result;
import commentservice.commentservice.entities.dtos.CommentSaveRequest;
import commentservice.commentservice.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin("*")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CommentSaveRequest commentSaveRequest){
        return commentService.add(commentSaveRequest);
    }

    @GetMapping("/getByUserId")
    public DataResult getByUserId(@RequestParam int userId){
        return commentService.findByUser(userId);
    }

    @GetMapping("/getByPostId")
    public DataResult getByPost(@RequestParam int postId){
        return commentService.findByPost(postId);
    }
    @GetMapping("/getByParentId")
    public DataResult getByParentId(@RequestParam int parentId){
        return commentService.findByParentId(parentId);
    }


}
