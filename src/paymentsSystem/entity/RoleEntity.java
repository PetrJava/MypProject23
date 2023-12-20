package paymentsSystem.entity;

import paymentsSystem.dto.RoleDto;

import java.util.Objects;

public class RoleEntity {
    private Integer roleId;
    private String role;

    public RoleEntity() {
    }

    public RoleEntity(int roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId);
    }

    @Override
    public String toString() {
        return "RoleDto{" +
               "role='" + role + '\'' +
               ", roleId=" + roleId +
               '}';
    }
}
