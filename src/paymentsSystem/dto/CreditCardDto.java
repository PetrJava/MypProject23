package paymentsSystem.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class CreditCardDto {

    private Integer cardId;
    private Integer cardNo;
    private BigDecimal creditCardBalance;
    private LocalDateTime createdTime;
    private LocalDateTime expireDate;

    public CreditCardDto() {
    }

    public CreditCardDto(Integer cardId, Integer cardNo, BigDecimal creditCardBalance, LocalDateTime createdTime, LocalDateTime expireDate) {
        this.cardId = cardId;
        this.cardNo = cardNo;
        this.creditCardBalance = creditCardBalance;
        this.createdTime = createdTime;
        this.expireDate = expireDate;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
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
        CreditCardDto that = (CreditCardDto) o;
        return Objects.equals(cardId, that.cardId) && Objects.equals(cardNo, that.cardNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardNo);
    }

    @Override
    public String toString() {
        return "CreditCardDto{" +
               "cardId=" + cardId +
               ", cardNo=" + cardNo +
               ", creditCardBalance=" + creditCardBalance +
               ", createdTime=" + createdTime +
               ", expireDate=" + expireDate +
               '}';
    }
}

