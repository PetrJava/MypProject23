package myProject.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BankAccount(
        Integer bank_account_id,
        BigDecimal bank_account_balance,
        LocalDateTime created_time) {
}
