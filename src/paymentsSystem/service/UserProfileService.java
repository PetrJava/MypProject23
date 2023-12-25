package paymentsSystem.service;

import paymentsSystem.dao.UserProfileDao;
import paymentsSystem.dto.UserCreateDto;
import paymentsSystem.dto.UserProfileDto;
import paymentsSystem.entity.UserProfileEntity;
import paymentsSystem.exception.ValidationException;
import paymentsSystem.mapper.MapperToEntity;
import paymentsSystem.mapper.UserProfileMapper;
import paymentsSystem.mapper.UserToDto;
import paymentsSystem.validator.CreateUserValidator;

import java.util.Optional;

public class UserProfileService {
    private UserProfileService() {
    }


    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserProfileDao userProfileDao = UserProfileDao.getInstance();
    private final MapperToEntity<UserCreateDto, UserProfileEntity> userMapper = new UserProfileMapper();
    private final UserToDto userToDto = UserToDto.getInstance();

    private static final UserProfileService INSTANCE = new UserProfileService();

    public static UserProfileService getInstance() {
        return INSTANCE;
    }

    public Optional<UserProfileDto> login(String email, String password) {
        return userProfileDao.findByEmailAndPassword(email, password)
                .map(userToDto::toDto);
    }

    public Integer create(UserCreateDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = userMapper.toEntity(userDto);
        userProfileDao.save(userEntity);
        return userEntity.getUserId();
    }


}
