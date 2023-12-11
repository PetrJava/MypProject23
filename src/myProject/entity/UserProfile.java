package myProject.entity;

import java.time.LocalDateTime;

public class UserProfile {
    private int user_id;
    private String login;
    private String password;
    private int role_id;
    private int status;
    private LocalDateTime created_time;

    public UserProfile(int user_id, String login, String password, int role_id, int status, LocalDateTime created_time) {
        this.user_id = user_id;
        this.login = login;
        this.password = password;
        this.role_id = role_id;
        this.status = status;
        this.created_time = created_time;
    }

    public UserProfile() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreated_time() {
        return created_time;
    }

    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
               "user_id=" + user_id +
               ", login='" + login + '\'' +
               ", password='" + password + '\'' +
               ", role_id=" + role_id +
               ", status=" + status +
               ", created_time=" + created_time +
               '}';
    }
}
