package postservice.postservice.entitites.dtos;

import jakarta.persistence.Column;

public record PostSaveRequest(String title,
                              String postText,
                              int subreddit,
                              int userId){
}
