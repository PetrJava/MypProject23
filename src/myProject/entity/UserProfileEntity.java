package myProject.entity;

import java.time.LocalDateTime;

public class UserProfileEntity {
    private Integer userId;
    private String login;
    private String password;
    private Integer roleId;
    private Integer status;
    private LocalDateTime createdTime;

    public UserProfileEntity(int userId, String login, String password, int roleId, int status, LocalDateTime createdTime) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
        this.status = status;
        this.createdTime = createdTime;
    }

    public UserProfileEntity() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
               "user_id=" + userId +
               ", login='" + login + '\'' +
               ", password='" + password + '\'' +
               ", role_id=" + roleId +
               ", status=" + status +
               ", created_time=" + createdTime +
               '}';
    }
}
