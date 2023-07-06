package subreddit.subredditService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="subreddit_users")
public class SubredditUser {

    @EmbeddedId
    private SubredditUserId subredditUserId;

    @MapsId("subreddit_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subreddit_id")
    private Subreddit subreddit;

    @Column(name="role")
    private int role;

    @Column(name="joinedat")
    private LocalDateTime joinedat;
}
