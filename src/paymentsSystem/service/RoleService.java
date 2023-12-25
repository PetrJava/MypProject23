package paymentsSystem.service;

import paymentsSystem.dao.RoleDao;
import paymentsSystem.dto.RoleDto;
import paymentsSystem.entity.RoleEntity;
import paymentsSystem.mapper.MapperToDto;
import paymentsSystem.mapper.RoleMapperToDto;

public class RoleService {
    public RoleService() {
    }

    private final MapperToDto<RoleEntity, RoleDto> roleMapper = new RoleMapperToDto();
    private final RoleDao roleDao = RoleDao.getInstance();
    private static final RoleService INSTANCE = new RoleService();

    public static RoleService getInstance() {
        return INSTANCE;
    }
}
