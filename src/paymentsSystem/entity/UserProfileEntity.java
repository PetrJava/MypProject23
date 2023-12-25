package paymentsSystem.entity;



import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@Builder
public class UserProfileEntity {

    private Integer userId;
    private String login;
    private String email;
    private String password;
    private Role role;
    private LocalDate createdTime;

    public UserProfileEntity(Integer userId, String login, String email, String password, Role role, LocalDate createdTime) {
        this.userId = userId;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdTime = createdTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }
}
