package paymentsSystem.service;

import paymentsSystem.dao.ClientDao;
import paymentsSystem.dto.ClientDto;
import paymentsSystem.entity.ClientEntity;
import paymentsSystem.mapper.BaseMapper;
import paymentsSystem.mapper.ClientMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ClientService {

    private final BaseMapper<ClientEntity, ClientDto> clientDtoMapper = new ClientMapper();

    private ClientService() {
    }

    private static final ClientService INSTANCE = new ClientService();
    private final ClientDao clientDao = ClientDao.getInstance();

    public static ClientService getInstance() {
        return INSTANCE;
    }

    public List<ClientDto> findAll() {
        return clientDao.findAll().stream()
                .map(clientDtoMapper::toDto)
                .collect(toList());
    }

}
