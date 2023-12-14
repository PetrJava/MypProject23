package paymentsSystem.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class BankAccountEntity {
    private Integer bankAccountId;
    private BigDecimal bankAccountBalance;
    private LocalDateTime createdTime;

    public BankAccountEntity() {
    }

    public BankAccountEntity(int bankAccountId, BigDecimal bankAccountBalance, LocalDateTime createdTime) {
        this.bankAccountId = bankAccountId;
        this.bankAccountBalance = bankAccountBalance;
        this.createdTime = createdTime;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public BigDecimal getBankAccountBalance() {
        return bankAccountBalance;
    }

    public void setBankAccountBalance(BigDecimal bankAccountBalance) {
        this.bankAccountBalance = bankAccountBalance;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccountEntity that = (BankAccountEntity) o;
        return Objects.equals(bankAccountId, that.bankAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccountId);
    }

    @Override
    public String toString() {
        return "Bank_account{" +
               "bankAccountId=" + bankAccountId +
               ", bank_account_balance=" + bankAccountBalance +
               ", created_time=" + createdTime +
               '}';
    }
}
