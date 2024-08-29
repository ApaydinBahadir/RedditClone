package commentservice.commentservice.entities.dtos;


public record CommentSaveRequest(String text,
                                 int parentId,
                                 int postId,
                                 int userId) {
}
