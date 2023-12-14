package paymentsSystem.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreditCardEntity {
    private Integer cardId;
    private Integer cardNo;
    private BigDecimal creditCardBalance;
    private LocalDateTime createdTime;
    private LocalDate expireDate;

    public CreditCardEntity(int cardId, int cardNo, BigDecimal creditCardBalance, LocalDateTime createdTime, LocalDate expireDate) {
        this.cardId = cardId;
        this.cardNo = cardNo;
        this.creditCardBalance = creditCardBalance;
        this.createdTime = createdTime;
        this.expireDate = expireDate;
    }

    public CreditCardEntity() {
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
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

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
               "card_id=" + cardId +
               ", card_no=" + cardNo +
               ", credit_card_balance=" + creditCardBalance +
               ", created_time=" + createdTime +
               ", expire_date=" + expireDate +
               '}';
    }
}
