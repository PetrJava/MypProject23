package myProject.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreditCard {
    private int card_id;
    private int card_no;
    private BigDecimal credit_card_balance;
    private LocalDateTime created_time;
    private LocalDate expire_date;

    public CreditCard(int card_id, int card_no, BigDecimal credit_card_balance, LocalDateTime created_time, LocalDate expire_date) {
        this.card_id = card_id;
        this.card_no = card_no;
        this.credit_card_balance = credit_card_balance;
        this.created_time = created_time;
        this.expire_date = expire_date;
    }

    public CreditCard() {
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getCard_no() {
        return card_no;
    }

    public void setCard_no(int card_no) {
        this.card_no = card_no;
    }

    public BigDecimal getCredit_card_balance() {
        return credit_card_balance;
    }

    public void setCredit_card_balance(BigDecimal credit_card_balance) {
        this.credit_card_balance = credit_card_balance;
    }

    public LocalDateTime getCreated_time() {
        return created_time;
    }

    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
    }

    public LocalDate getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(LocalDate expire_date) {
        this.expire_date = expire_date;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
               "card_id=" + card_id +
               ", card_no=" + card_no +
               ", credit_card_balance=" + credit_card_balance +
               ", created_time=" + created_time +
               ", expire_date=" + expire_date +
               '}';
    }
}
