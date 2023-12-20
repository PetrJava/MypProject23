package paymentsSystem.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class CreditCardEntity {
    private BankAccountEntity bankAccountEntity;
    private Integer cardNo;
    private BigDecimal creditCardBalance;
    private LocalDateTime createdTime;
    private LocalDateTime expireDate;

    public CreditCardEntity(BankAccountEntity bankAccountEntity, Integer cardNo, BigDecimal creditCardBalance, LocalDateTime createdTime, LocalDateTime expireDate) {
        this.bankAccountEntity = bankAccountEntity;
        this.cardNo = cardNo;
        this.creditCardBalance = creditCardBalance;
        this.createdTime = createdTime;
        this.expireDate = expireDate;
    }

    public BankAccountEntity getBankAccountEntity() {
        return bankAccountEntity;
    }

    public void setBankAccountEntity(BankAccountEntity bankAccountEntity) {
        this.bankAccountEntity = bankAccountEntity;
    }

    public Integer getCardNo() {
        return cardNo;
    }

    public void setCardNo(Integer cardNo) {
        this.cardNo = cardNo;
    }

    public BigDecimal getCreditCardBalance() {
        return creditCardBalance;
    }

    public void setCreditCardBalance(BigDecimal creditCardBalance) {
        this.creditCardBalance = creditCardBalance;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCardEntity that = (CreditCardEntity) o;
        return Objects.equals(bankAccountEntity, that.bankAccountEntity) && Objects.equals(cardNo, that.cardNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccountEntity, cardNo);
    }

    @Override
    public String toString() {
        return "CreditCardEntity{" +
               "bankAccountEntity=" + bankAccountEntity +
               ", cardNo=" + cardNo +
               ", creditCardBalance=" + creditCardBalance +
               ", createdTime=" + createdTime +
               ", expireDate=" + expireDate +
               '}';
    }
}