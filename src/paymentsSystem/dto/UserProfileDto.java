package paymentsSystem.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import paymentsSystem.entity.Role;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Value
@Builder
public class UserProfileDto {

    Integer userId;
    String login;
    String email;
    Role role;
    LocalDate createdTime;

}

