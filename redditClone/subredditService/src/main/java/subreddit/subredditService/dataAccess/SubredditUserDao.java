package subreddit.subredditService.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import subreddit.subredditService.entity.SubredditUser;
import subreddit.subredditService.entity.SubredditUserId;

import java.util.List;
@Repository
public interface SubredditUserDao extends JpaRepository<SubredditUser, SubredditUserId> {
    @Query(value = "SELECT * FROM subreddit_users u WHERE u.subreddit_id = :subredditId and u.user_id = :userId",
            nativeQuery = true)
    SubredditUser findByUserIdAndSubredditId(@Param("subredditId") int subredditId,@Param("userId") int userId);
    @Query(value = "DELETE u FROM subreddit_users u WHERE u.SubredditUserId.subredditId = ?1 AND u.SubredditUserId.userId = ?2", nativeQuery = true)
    SubredditUser deleteUserIdAndSubredditId(int subredditId, int userId);

    @Query(value = "SELECT u.subreddit_id FROM subreddit_users u WHERE u.user_id = :userId", nativeQuery = true)
    List<Integer> findSubredditByUserId(@Param("userId") int userId);



}