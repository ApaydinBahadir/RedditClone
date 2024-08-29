package postservice.postservice.dataAccess;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import postservice.postservice.entitites.Post;

import java.util.List;
@Repository
public interface PostDao extends JpaRepository<Post,Integer> {
    List<Post> findByUserid(int userid);
    List<Post> findBySubreddit(int subredditId);
    @Query(value = "SELECT * FROM posts u WHERE u.post_id = :postId", nativeQuery = true)
    List<Post> getByPostId(@Param("postId") int postId);
}
