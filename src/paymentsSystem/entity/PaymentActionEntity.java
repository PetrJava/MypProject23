package paymentsSystem.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class PaymentActionEntity {

    private TypeOperationEntity typeOperationEntity;
    private LocalDateTime dateAndTime;
    private BigDecimal transactionAmount;
    private BankAccountEntity bankAccountEntityFrom;
    private BankAccountEntity bankAccountEntityTo;
    private String status;
    private Integer paymentActionNo;

    public PaymentActionEntity(TypeOperationEntity typeOperationEntity, LocalDateTime dateAndTime,
                               BigDecimal transactionAmount, BankAccountEntity bankAccountEntityFrom, BankAccountEntity bankAccountEntityTo, String status, Integer paymentActionNo) {
        this.typeOperationEntity = typeOperationEntity;
        this.dateAndTime = dateAndTime;
        this.transactionAmount = transactionAmount;
        this.bankAccountEntityFrom = bankAccountEntityFrom;
        this.bankAccountEntityTo = bankAccountEntityTo;
        this.status = status;
        this.paymentActionNo = paymentActionNo;
    }

    public TypeOperationEntity getTypeOperationEntity() {
        return typeOperationEntity;
    }

    public void setTypeOperationEntity(TypeOperationEntity typeOperationEntity) {
        this.typeOperationEntity = typeOperationEntity;
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

    public BankAccountEntity getBankAccountEntityFrom() {
        return bankAccountEntityFrom;
    }

    public void setBankAccountEntityFrom(BankAccountEntity bankAccountEntityFrom) {
        this.bankAccountEntityFrom = bankAccountEntityFrom;
    }

    public BankAccountEntity getBankAccountEntityTo() {
        return bankAccountEntityTo;
    }

    public void setBankAccountEntityTo(BankAccountEntity bankAccountEntityTo) {
        this.bankAccountEntityTo = bankAccountEntityTo;
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
        PaymentActionEntity that = (PaymentActionEntity) o;
        return Objects.equals(typeOperationEntity, that.typeOperationEntity) && Objects.equals(paymentActionNo, that.paymentActionNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOperationEntity, paymentActionNo);
    }

    @Override
    public String toString() {
        return "PaymentActionEntity{" +
               "typeOperationEntity=" + typeOperationEntity +
               ", dateAndTime=" + dateAndTime +
               ", transactionAmount=" + transactionAmount +
               ", bankAccountEntityFrom=" + bankAccountEntityFrom +
               ", bankAccountEntityTo=" + bankAccountEntityTo +
               ", status='" + status + '\'' +
               ", paymentActionNo=" + paymentActionNo +
               '}';
    }
}
