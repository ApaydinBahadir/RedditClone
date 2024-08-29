package postservice.postservice.entitites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    @Column(name="post_id")
    private int postId;

    @Column(name="title")
    private String title;

    @Column(name="posttext")
    private String post_text;

    @Column(name="subreddit")
    private int subreddit;

    @Column(name="userid")
    private int userid;

    @Column(name="createdat")
    private LocalDateTime created_at;
}
