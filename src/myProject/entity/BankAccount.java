package myProject.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BankAccount {
    private int bank_account_id;
    private BigDecimal bank_account_balance;
    private LocalDateTime created_time;

    public BankAccount(int bank_account_id, BigDecimal bank_account_balance, LocalDateTime created_time) {
        this.bank_account_id = bank_account_id;
        this.bank_account_balance = bank_account_balance;
        this.created_time = created_time;
    }

    public BankAccount() {
    }

    public int getBank_account_id() {
        return bank_account_id;
    }

    public void setBank_account_id(int bank_account_id) {
        this.bank_account_id = bank_account_id;
    }

    public BigDecimal getBank_account_balance() {
        return bank_account_balance;
    }

    public void setBank_account_balance(BigDecimal bank_account_balance) {
        this.bank_account_balance = bank_account_balance;
    }

    public LocalDateTime getCreated_time() {
        return created_time;
    }

    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
    }

    @Override
    public String toString() {
        return "Bank_account{" +
               "bank_account_id=" + bank_account_id +
               ", bank_account_balance=" + bank_account_balance +
               ", created_time=" + created_time +
               '}';
    }
}
