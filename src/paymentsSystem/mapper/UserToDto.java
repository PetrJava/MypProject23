package paymentsSystem.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import paymentsSystem.dto.UserProfileDto;
import paymentsSystem.entity.Role;
import paymentsSystem.entity.UserProfileEntity;

import static lombok.AccessLevel.*;

@NoArgsConstructor(access = PRIVATE)
public class UserToDto implements MapperToDto<UserProfileEntity, UserProfileDto> {

    private static final UserToDto INSTANCE = new UserToDto();


    @Override
    public UserProfileDto toDto(UserProfileEntity entity) {
        return UserProfileDto.builder()
                .userId(entity.getUserId())
                .login(entity.getLogin())
                .email(entity.getEmail())
                .role(entity.getRole())
                .createdTime(entity.getCreatedTime())
                .build();
    }

    public static UserToDto getInstance() {
        return INSTANCE;
    }

}
