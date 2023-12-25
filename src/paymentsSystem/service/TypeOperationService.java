package paymentsSystem.service;

import paymentsSystem.dao.ClientDao;
import paymentsSystem.dao.TypeOperationDao;
import paymentsSystem.dto.ClientDto;
import paymentsSystem.dto.TypeOperationDto;
import paymentsSystem.entity.ClientEntity;
import paymentsSystem.entity.TypeOperationEntity;
import paymentsSystem.mapper.ClientMapperToDto;
import paymentsSystem.mapper.MapperToDto;
import paymentsSystem.mapper.TypeOperationMapperToDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TypeOperationService {
    public TypeOperationService() {
    }

    private final MapperToDto<TypeOperationEntity, TypeOperationDto> typeMapper = new TypeOperationMapperToDto();
    private final TypeOperationDao typeOperationDao = TypeOperationDao.getInstance();
    private static final TypeOperationService INSTANCE = new TypeOperationService();

    public static TypeOperationService getInstance() {
        return INSTANCE;
    }

    public List<TypeOperationDto> findAll() {
        return typeOperationDao.findAll().stream()
                .map(typeMapper::toDto)
                .collect(toList());
    }

}
