package subreddit.subredditService.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import subreddit.subredditService.entity.Subreddit;

import java.util.Collection;
import java.util.List;
@Repository
public interface SubredditDao extends JpaRepository<Subreddit,Integer> {
    Subreddit getById(int id);

    List<Subreddit> getByNameStartsWith(String name);

    @Query(value = "SELECT * FROM subreddit u WHERE u.subreddit_id = :subredditId", nativeQuery = true)
    List<Subreddit> findPostsBySubredditId(@Param("subredditId") int subreddit_id);

    @Query(value = "SELECT u.name FROM subreddit u WHERE u.subreddit_id = :subredditId", nativeQuery = true)
    String findSubredditNamesByUserId(@Param("subredditId") int subredditId);

    @Query(value = "SELECT * FROM subreddit u WHERE u.subreddit_id = :subredditId", nativeQuery = true)
    Collection<? extends Subreddit> findSubredditByUserId(@Param("subredditId") int subredditId);
}
