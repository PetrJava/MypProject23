package paymentsSystem.entity;


import java.time.LocalDateTime;
import java.util.Objects;

public class ClientEntity {
    private Integer clientId;
    private String firstName;
    private String lastName;
    private BankAccountEntity bankAccountEntity;
    private LocalDateTime createdTime;

    public ClientEntity() {
    }

    public ClientEntity(Integer clientId, String firstName, String lastName,
                        BankAccountEntity bankAccountEntity, LocalDateTime createdTime) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankAccountEntity = bankAccountEntity;
        this.createdTime = createdTime;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
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

    public BankAccountEntity getBankAccountEntity() {
        return bankAccountEntity;
    }

    public void setBankAccountEntity(BankAccountEntity bankAccountEntity) {
        this.bankAccountEntity = bankAccountEntity;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return Objects.equals(clientId, that.clientId) && Objects.equals(bankAccountEntity, that.bankAccountEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, bankAccountEntity);
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
