package paymentsSystem.service;

import paymentsSystem.dao.BankAccountDao;
import paymentsSystem.dto.BankAccountDto;
import paymentsSystem.entity.BankAccountEntity;
import paymentsSystem.mapper.BankAccountMapperToDto;
import paymentsSystem.mapper.MapperToDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BankAccountService {
    private BankAccountService() {
    }

    private static final BankAccountService INSTANCE = new BankAccountService();

    private final BankAccountDao bankAccountDao = BankAccountDao.getInstance();
    private final MapperToDto<BankAccountEntity, BankAccountDto> bankDtoMapper = new BankAccountMapperToDto();

    public static BankAccountService getInstance() {
        return INSTANCE;
    }

    public List<BankAccountDto> findAll() {
        return bankAccountDao.findAll().stream()
                .map(bankDtoMapper::toDto)
                .collect(toList());
    }

    public List<BankAccountDto> findByBankAccountId(Integer bankAccountId) {
        return bankAccountDao.getFindByBankAccountId(bankAccountId).stream()
                .map(bankDtoMapper::toDto)
                .collect(toList());
    }

    public BankAccountEntity save(BankAccountEntity bankAccountEntity) {
        return bankAccountDao.save(bankAccountEntity);


    }


}

