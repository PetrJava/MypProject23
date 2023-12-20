package paymentsSystem.service;

import paymentsSystem.dao.BankAccountDao;
import paymentsSystem.dto.BankAccountDto;
import paymentsSystem.entity.BankAccountEntity;
import paymentsSystem.mapper.BankAccountMapper;
import paymentsSystem.mapper.BaseMapper;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class BankAccountService {
    private BankAccountService() {
    }

    private static final BankAccountService INSTANCE = new BankAccountService();

    private final BankAccountDao bankAccountDao = BankAccountDao.getInstance();
    private final BaseMapper<BankAccountEntity, BankAccountDto> bankDtoMapper = new BankAccountMapper();

    public static BankAccountService getInstance() {
        return INSTANCE;
    }

    public List<BankAccountDto> findAll() {
        return bankAccountDao.findAll().stream()
                .map(bankDtoMapper::toDto)
                .collect(toList());
    }

    public List<BankAccountDto> getFindByBankAccountId(Integer bankAccountId) {
        return bankAccountDao.getFindByBankAccountId(bankAccountId).stream()
                .map(bankDtoMapper::toDto)
                .collect(toList());
    }

    public BankAccountEntity save(BankAccountEntity bankAccountEntity) {
        return bankAccountDao.save(bankAccountEntity);


    }


}

