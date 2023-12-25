package paymentsSystem.dto;


import lombok.Builder;
import lombok.Value;
import paymentsSystem.entity.Role;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Value
@Builder
public class UserProfileDto {

     Integer userId;
     String login;
     String email;
     Role role;
     LocalDate createdTime;


}


/**  private Integer userId;
 private String login;
 private String email;
 private String password;
 private String role;
 private LocalDate createdTime;

 public UserProfileDto() {
 }

 public String getEmail() {
 return email;
 }

 public void setEmail(String email) {
 this.email = email;
 }

 public UserProfileDto(Integer userId, String login, String password, String role, LocalDate createdTime) {
 this.userId = userId;
 this.login = login;
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

 public String getPassword() {
 return password;
 }

 public void setPassword(String password) {
 this.password = password;
 }

 public String getRole() {
 return role;
 }

 public void setRole(String role) {
 this.role = role;
 }


 public LocalDate getCreatedTime() {
 return createdTime;
 }

 public void setCreatedTime(LocalDate createdTime) {
 this.createdTime = createdTime;
 }

 @Override
 public boolean equals(Object o) {
 if (this == o) return true;
 if (o == null || getClass() != o.getClass()) return false;
 UserProfileDto that = (UserProfileDto) o;
 return Objects.equals(userId, that.userId) && Objects.equals(login, that.login);
 }

 @Override
 public int hashCode() {
 return Objects.hash(userId, login);
 }

 @Override
 public String toString() {
 return "UserProfileDto{" +
 "userId=" + userId +
 ", login='" + login + '\'' +
 ", password='" + password + '\'' +
 ", roleId=" + role +
 ", createdTime=" + createdTime +
 '}';
 }*/
