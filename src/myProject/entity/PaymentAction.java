package myProject.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentAction {

    private int payment_action_id;
    private LocalDateTime date_and_time;
    private BigDecimal transaction_amount;
    private int transaction_from;
    private int transaction_to;
    private String status;

    public PaymentAction(int payment_action_id, LocalDateTime date_and_time, BigDecimal transaction_amount,
                         int transaction_from, int transaction_to, String status) {
        this.payment_action_id = payment_action_id;
        this.date_and_time = date_and_time;
        this.transaction_amount = transaction_amount;
        this.transaction_from = transaction_from;
        this.transaction_to = transaction_to;
        this.status = status;
    }

    public PaymentAction() {
    }

    public int getPayment_action_id() {
        return payment_action_id;
    }

    public void setPayment_action_id(int payment_action_id) {
        this.payment_action_id = payment_action_id;
    }

    public LocalDateTime getDate_and_time() {
        return date_and_time;
    }

    public void setDate_and_time(LocalDateTime date_and_time) {
        this.date_and_time = date_and_time;
    }

    public BigDecimal getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(BigDecimal transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public int getTransaction_from() {
        return transaction_from;
    }

    public void setTransaction_from(int transaction_from) {
        this.transaction_from = transaction_from;
    }

    public int getTransaction_to() {
        return transaction_to;
    }

    public void setTransaction_to(int transaction_to) {
        this.transaction_to = transaction_to;
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
               "payment_action_id=" + payment_action_id +
               ", date_and_time=" + date_and_time +
               ", transaction_amount=" + transaction_amount +
               ", transaction_from=" + transaction_from +
               ", transaction_to=" + transaction_to +
               ", status='" + status + '\'' +
               '}';
    }
}
