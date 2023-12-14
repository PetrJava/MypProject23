package paymentsSystem.entity;

import java.time.LocalDateTime;

public class ClientEntity {
    private Integer clientId;
    private String firstName;
    private String lastName;
    private BankAccountEntity bankAccountEntity;
    private LocalDateTime createdTime;

    public ClientEntity(int clientId, String firstName, String lastName, BankAccountEntity bankAccountEntity,
                        LocalDateTime createdTime) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankAccountEntity = bankAccountEntity;
        this.createdTime = createdTime;
    }

    public ClientEntity() {
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BankAccountEntity getBankAccount() {
        return bankAccountEntity;
    }

    public void setBankAccount(BankAccountEntity bankAccountEntity) {
        this.bankAccountEntity = bankAccountEntity;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Client{" +
               "client_id=" + clientId +
               ", first_name='" + firstName + '\'' +
               ", last_name='" + lastName + '\'' +
               ", bank_account=" + bankAccountEntity +
               ", created_time=" + createdTime +
               '}';
    }
}
