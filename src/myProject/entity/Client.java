package myProject.entity;

import myProject.dto.BankAccount;

import java.time.LocalDateTime;

public class Client {
    private int client_id;
    private String first_name;
    private String last_name;
    private BankAccount bank_account;
    private LocalDateTime created_time;

    public Client() {
    }

    public Client(int client_id, String first_name, String last_name, BankAccount bankAccount,
                  LocalDateTime created_time) {
        this.client_id = client_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.bank_account = bankAccount;
        this.created_time = created_time;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public BankAccount getBank_account() {
        return bank_account;
    }

    public void setBank_account(BankAccount bank_account) {
        this.bank_account = bank_account;
    }

    public LocalDateTime getCreated_time() {
        return created_time;
    }

    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
    }

    @Override
    public String toString() {
        return "Client{" +
               "client_id=" + client_id +
               ", first_name='" + first_name + '\'' +
               ", last_name='" + last_name + '\'' +
               ", bank_account=" + bank_account +
               ", created_time=" + created_time +
               '}';
    }
}
