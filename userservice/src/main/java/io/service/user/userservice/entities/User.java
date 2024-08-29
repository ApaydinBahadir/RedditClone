package io.service.user.userservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
@Builder
public class User {

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private int userid;

    @Column(name="username")
    private String username;

    @Column(name="joined_at")
    private LocalDateTime joined_at;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    // TODO: 5/31/2023 Field

}
