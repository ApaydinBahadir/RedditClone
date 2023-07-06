package postservice.postservice.entitites.dtos;

import jakarta.persistence.Column;

public record PostSaveRequest(String title,
                              String post_text,
                              int subreddit,
                              int userid){
}
