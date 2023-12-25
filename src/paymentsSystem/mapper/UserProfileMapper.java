package paymentsSystem.mapper;

import paymentsSystem.dto.UserCreateDto;
import paymentsSystem.dto.UserProfileDto;
import paymentsSystem.entity.Role;
import paymentsSystem.entity.RoleEntity;
import paymentsSystem.entity.UserProfileEntity;
import paymentsSystem.util.LocalDateFormatter;

import java.time.LocalDate;

public class UserProfileMapper implements MapperToEntity<UserCreateDto, UserProfileEntity>, MapperToDto<UserProfileEntity, UserProfileDto> {

    private static final UserProfileMapper INSTANCE = new UserProfileMapper();
    private final RoleEntity roleEntity = new RoleEntity();

//    @Override
//    public UserProfileDto toDto(UserProfileEntity entity) {
//        var user = new UserProfileDto();
//        user.setUserId(entity.getUserId());
//        user.setLogin(entity.getLogin());
//        user.setEmail(entity.getEmail());
//        user.setPassword(entity.getPassword());
//        user.setRole(String.valueOf(entity.getRole()));
//        user.setCreatedTime(entity.getCreatedTime());
//        return user;
//    }



    @Override
    public UserProfileEntity toEntity(UserCreateDto dto) {
        return UserProfileEntity.builder()
                .login(dto.getLogin())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(Role.valueOf(dto.getRole()))
                .createdTime(LocalDate.parse(dto.getCreatedTime()))
                .build();
    }

    public static UserProfileMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public UserProfileDto toDto(UserProfileEntity entity) {
        return null;
    }
}
