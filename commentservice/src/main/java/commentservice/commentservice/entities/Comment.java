package commentservice.commentservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private int commentId;

    @Column(name = "text")
    private String text;

    @Column(name = "parentid")
    private int parentId;

    @Column(name = "postid")
    private int postId;

    @Column(name = "userid")
    private int userId;

    @Column(name = "created_time")
    private LocalDateTime createdTime;
}
