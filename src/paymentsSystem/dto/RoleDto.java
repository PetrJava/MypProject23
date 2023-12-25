package paymentsSystem.dto;

import paymentsSystem.entity.Role;

import java.util.Objects;

public class RoleDto {

    private Role role;
    private Integer roleId;

    public RoleDto() {
    }

    public RoleDto(Role role, Integer roleId) {
        this.role = role;
        this.roleId = roleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
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
        RoleDto roleDto = (RoleDto) o;
        return Objects.equals(roleId, roleDto.roleId);
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
