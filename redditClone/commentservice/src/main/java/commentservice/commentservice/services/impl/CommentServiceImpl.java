package commentservice.commentservice.services.impl;

import commentservice.commentservice.core.utilities.results.DataResult;
import commentservice.commentservice.core.utilities.results.Result;
import commentservice.commentservice.dataAccess.CommentDao;
import commentservice.commentservice.entities.Comment;
import commentservice.commentservice.entities.dtos.CommentSaveRequest;
import commentservice.commentservice.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao){
        super();
        this.commentDao = commentDao;
    }

    @Override
    public Result add(CommentSaveRequest commentSaveRequest) {
        commentDao.save(Comment.builder()
                        .text(commentSaveRequest.text())
                        .userId(commentSaveRequest.userId())
                        .postId(commentSaveRequest.postId())
                        .createdTime(LocalDateTime.now())
                        .parentId(commentSaveRequest.parentId())
                        .build());
        return new Result(true,"Comment Saved");
    }

    @Override
    public DataResult findByPost(int postId) {
        return new DataResult(commentDao.findByPostId(postId),true,"Data Listed");
    }

    @Override
    public DataResult findByParentId(int parentId) {
        return new DataResult(commentDao.findByParentId(parentId),true,"Data Listed");
    }

    @Override
    public DataResult findByUser(int userId) {
        return new DataResult(commentDao.findByUserId(userId),true,"Data Listed");
    }

}
