package paymentsSystem.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class BankAccountDto {
        private final Integer bankAccountId;
        private final BigDecimal bankAccountBalance;
        private final LocalDateTime createdTime;


    public BankAccountDto(Integer bankAccountId, BigDecimal bankAccountBalance, LocalDateTime createdTime) {
        this.bankAccountId = bankAccountId;
        this.bankAccountBalance = bankAccountBalance;
        this.createdTime = createdTime;
    }

//    public BankAccountDto(Integer bankAccountId, BigDecimal bankAccountBalance) {
//        this.bankAccountId = bankAccountId;
//        this.bankAccountBalance = bankAccountBalance;
//
//    }


    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public BigDecimal getBankAccountBalance() {
        return bankAccountBalance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccountDto that = (BankAccountDto) o;
        return Objects.equals(bankAccountId, that.bankAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccountId);
    }

    @Override
    public String toString() {
        return "BankAccountDto{" +
               "bankAccountId=" + bankAccountId +
               ", bankAccountBalance=" + bankAccountBalance +
               '}';
    }
}
