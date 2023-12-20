package paymentsSystem.dto;

import java.time.LocalDateTime;
import java.util.Objects;


public class ClientDto {

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    private Integer clientId;
    private String firstName;
    private String lastName;
    private Integer accountId;
    private LocalDateTime createdTime;

    private String info;

    public ClientDto() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ClientDto(Integer clientId, String info) {
        this.clientId = clientId;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }


    public ClientDto(Integer clientId, String firstName, String lastName, Integer accountId, LocalDateTime createdTime) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountId = accountId;
        this.createdTime = createdTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(clientId, clientDto.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }

    public Integer getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
}

