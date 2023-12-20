package paymentsSystem.entity;


import java.time.LocalDateTime;
import java.util.Objects;

public class UserProfileEntity {

    private ClientEntity clientEntity;
    private String login;
    private String password;
    private RoleEntity roleEntity;
    private Integer status;
    private LocalDateTime createdTime;

    public UserProfileEntity() {
    }

    public UserProfileEntity(ClientEntity clientEntity, String login, String password, RoleEntity roleEntity, Integer status, LocalDateTime createdTime) {
        this.clientEntity = clientEntity;
        this.login = login;
        this.password = password;
        this.roleEntity = roleEntity;
        this.status = status;
        this.createdTime = createdTime;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
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

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileEntity that = (UserProfileEntity) o;
        return Objects.equals(clientEntity, that.clientEntity) && Objects.equals(login, that.login) && Objects.equals(roleEntity, that.roleEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientEntity, login, roleEntity);
    }

    @Override
    public String toString() {
        return "UserProfileEntity{" +
               "clientEntity=" + clientEntity +
               ", login='" + login + '\'' +
               ", password='" + password + '\'' +
               ", roleEntity=" + roleEntity +
               ", status=" + status +
               ", createdTime=" + createdTime +
               '}';
    }
}
