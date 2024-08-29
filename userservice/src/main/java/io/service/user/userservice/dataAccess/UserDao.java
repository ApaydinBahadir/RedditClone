package io.service.user.userservice.dataAccess;

import io.service.user.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    User getByUsername(String username);
    @Query(value = "SELECT * FROM users u WHERE u.user_id = :userId", nativeQuery = true)
    User getByUserid(@Param("userId") int id);
    @Query(value = "SELECT u.username FROM users u WHERE u.user_id = :userId", nativeQuery = true)
    String getUsernameByUserid(@Param("userId") int id);
    @Query(value = "SELECT * FROM users u WHERE u.user_id = :userId", nativeQuery = true)
    User getDataByUserid(@Param("userId") int userId);
    List<User> getByUsernameContains(String Username);
    List<User> getByUsernameStartsWith(String Username);

}
