package myProject.entity;

public class RoleEntity {
    private Integer roleId;
    private String role;

    public RoleEntity(int roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    public RoleEntity() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
               "role_id=" + roleId +
               ", role='" + role + '\'' +
               '}';
    }
}
