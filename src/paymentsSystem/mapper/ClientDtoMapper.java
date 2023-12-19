package paymentsSystem.mapper;

import paymentsSystem.dto.ClientDto;
import paymentsSystem.entity.ClientEntity;

public class ClientDtoMapper implements BaseMapper<ClientEntity, ClientDto> {

    @Override
    public ClientDto toDto(ClientEntity entity) {
        var clientDto = new ClientDto();
        clientDto.setClientId(entity.getClientId());
        clientDto.setFirstName(entity.getFirstName());
        clientDto.setLastName(entity.getLastName());
        clientDto.setAccountId(entity.getBankAccount().getBankAccountId());
        clientDto.setCreatedTime(entity.getCreatedTime());
        clientDto.setInfo(buildInfo(entity.getFirstName(), entity.getLastName()));
        return clientDto;

    }

    private String buildInfo(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

}
