package paymentsSystem.service;

import paymentsSystem.dao.BankAccountDao;
import paymentsSystem.dto.BankAccountDto;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class BankAccountService {
    private BankAccountService() {
    }

    private static final BankAccountService INSTANCE = new BankAccountService();

    private final BankAccountDao bankAccountDao = BankAccountDao.getInstance();

    public static BankAccountService getInstance() {
        return INSTANCE;
    }

    public List<BankAccountDto> findAll() {
        return bankAccountDao.findAll().stream()
                .map(bankAccountEntity -> new BankAccountDto(
                        bankAccountEntity.getBankAccountId(), bankAccountEntity.getBankAccountBalance(), bankAccountEntity.getCreatedTime()))
                .collect(toList());
    }

    public List<BankAccountDto> getFindByBankAccountId(Integer bankAccountId) {
        return bankAccountDao.getFindByBankAccountId(bankAccountId).stream()
                .map(bankAccountEntity -> new BankAccountDto(
                        bankAccountEntity.getBankAccountId(), bankAccountEntity.getBankAccountBalance(), bankAccountEntity.getCreatedTime()))
                .collect(toList());
    }

}

