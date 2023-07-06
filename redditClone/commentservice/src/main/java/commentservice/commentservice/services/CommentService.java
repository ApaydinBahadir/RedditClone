package commentservice.commentservice.services;

import commentservice.commentservice.core.utilities.results.DataResult;
import commentservice.commentservice.core.utilities.results.Result;
import commentservice.commentservice.entities.dtos.CommentSaveRequest;

import java.util.List;

public interface CommentService {
    Result add(CommentSaveRequest commentSaveRequest);
    DataResult findByPost(int postId);
    DataResult findByParentId(int parentId);
    DataResult findByUser(int userId);
}
