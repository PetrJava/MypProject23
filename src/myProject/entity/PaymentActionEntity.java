package myProject.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentActionEntity {

    private Integer paymentActionId;
    private LocalDateTime dateAndTime;
    private BigDecimal transactionAmount;
    private Integer transactionFrom;
    private Integer transactionTo;
    private String status;

    public PaymentActionEntity(int paymentActionId, LocalDateTime dateAndTime, BigDecimal transactionAmount,
                               int transactionFrom, int transactionTo, String status) {
        this.paymentActionId = paymentActionId;
        this.dateAndTime = dateAndTime;
        this.transactionAmount = transactionAmount;
        this.transactionFrom = transactionFrom;
        this.transactionTo = transactionTo;
        this.status = status;
    }

    public PaymentActionEntity() {
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

    @Override
    public String toString() {
        return "PaymentAction{" +
               "payment_action_id=" + paymentActionId +
               ", date_and_time=" + dateAndTime +
               ", transaction_amount=" + transactionAmount +
               ", transaction_from=" + transactionFrom +
               ", transaction_to=" + transactionTo +
               ", status='" + status + '\'' +
               '}';
    }
}
