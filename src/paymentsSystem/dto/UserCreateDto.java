package paymentsSystem.dto;

import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class UserCreateDto {
    String userId;
    String login;
    String email;
    String password;
    String role;
    String createdTime;
}
