package subreddit.subredditService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="subreddit")
@Builder
public class Subreddit {
    @Id
    @GeneratedValue
    @Column(name = "subreddit_id")
    private int subredditId;

    @Column(name="name")
    private String name;

    @Column(name="about")
    private String about;

    @Column(name="created_at")
    private LocalDateTime createdAt;



}