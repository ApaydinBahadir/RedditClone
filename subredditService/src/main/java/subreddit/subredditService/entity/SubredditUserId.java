package subreddit.subredditService.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Data
public class SubredditUserId implements Serializable {

    @Column(name = "user_id")
    private int userId;

    @Column(name = "subreddit_id")
    private int subredditId;

}
