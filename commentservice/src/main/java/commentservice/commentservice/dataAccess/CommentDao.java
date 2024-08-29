package commentservice.commentservice.dataAccess;

import commentservice.commentservice.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentDao extends JpaRepository<Comment,Integer> {
    @Query(value = "SELECT * FROM comments u WHERE u.postId = :postId", nativeQuery = true)
    List<Comment> findByPostId(@Param("postId") int postId);
    @Query(value = "SELECT u FROM comments u WHERE u.parentid = ?1", nativeQuery = true)
    List<Comment> findByParentId(int postId);
    @Query(value = "SELECT u FROM comments u WHERE u.userid = NULL", nativeQuery = true)
    List<Comment> findByUserId(int userId);
}
