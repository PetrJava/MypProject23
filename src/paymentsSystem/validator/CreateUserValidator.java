package paymentsSystem.validator;

import paymentsSystem.dto.UserCreateDto;
import paymentsSystem.service.UserProfileService;
import paymentsSystem.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<UserCreateDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidationResult isValid(UserCreateDto dto) {
        var validationResult = new ValidationResult();
        if (!LocalDateFormatter.isValid(dto.getCreatedTime())) {
            validationResult.add(Error.of("invalid date", "Date is invalid"));
        }
        if (dto.getPassword().length() < 3){
            validationResult.add(Error.of("password length", "Password must be at least 3 characters"));
        }
        if (dto.getLogin().length() < 4 ){
            validationResult.add(Error.of("login length", "Login must be at least 4 characters"));
        }
        return validationResult;
    }
}
