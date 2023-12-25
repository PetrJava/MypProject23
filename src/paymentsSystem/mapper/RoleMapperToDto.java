package paymentsSystem.mapper;

import paymentsSystem.dto.RoleDto;
import paymentsSystem.entity.Role;
import paymentsSystem.entity.RoleEntity;

public class RoleMapperToDto implements MapperToDto<RoleEntity, RoleDto> {

    @Override
    public RoleDto toDto(RoleEntity entity) {
        var role = new RoleDto();
        role.setRole(Role.valueOf(entity.getRole()));
        role.setRoleId(entity.getRoleId());
        return role;
    }

}
