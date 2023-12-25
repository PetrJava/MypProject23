package paymentsSystem.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class PaymentActionDto {

    public PaymentActionDto() {
    }

    private Integer paymentActionId;
    private LocalDateTime dateAndTime;
    private BigDecimal transactionAmount;
    private Integer transactionFrom;
    private Integer transactionTo;
    private String status;
    private Integer paymentActionNo;




    public PaymentActionDto(int paymentActionId, LocalDateTime dateAndTime, BigDecimal transactionAmount,
                            int transactionFrom, int transactionTo, String status, Integer paymentActionNo) {
        this.paymentActionId = paymentActionId;
        this.dateAndTime = dateAndTime;
        this.transactionAmount = transactionAmount;
        this.transactionFrom = transactionFrom;
        this.transactionTo = transactionTo;
        this.status = status;
        this.paymentActionNo = paymentActionNo;
    }


    public int getPaymentActionId() {
        return paymentActionId;
    }

    public void setPaymentActionId(int paymentActionId) {
        this.paymentActionId = paymentActionId;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getTransactionFrom() {
        return transactionFrom;
    }

    public void setTransactionFrom(int transactionFrom) {
        this.transactionFrom = transactionFrom;
    }

    public int getTransactionTo() {
        return transactionTo;
    }

    public void setTransactionTo(int transactionTo) {
        this.transactionTo = transactionTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPaymentActionNo() {
        return paymentActionNo;
    }

    public void setPaymentActionNo(Integer paymentActionNo) {
        this.paymentActionNo = paymentActionNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentActionDto that = (PaymentActionDto) o;
        return Objects.equals(paymentActionNo, that.paymentActionNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentActionNo);
    }

    @Override
    public String toString() {
        return "PaymentActionDto{" +
               "paymentActionId=" + paymentActionId +
               ", dateAndTime=" + dateAndTime +
               ", transactionAmount=" + transactionAmount +
               ", transactionFrom=" + transactionFrom +
               ", transactionTo=" + transactionTo +
               ", status='" + status + '\'' +
               ", paymentActionNo=" + paymentActionNo +
               '}';
    }
}
