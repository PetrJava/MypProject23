package paymentsSystem.mapper;

import paymentsSystem.dto.BankAccountDto;
import paymentsSystem.entity.BankAccountEntity;

public class BankAccountMapperToDto implements MapperToDto<BankAccountEntity, BankAccountDto> {
    @Override
    public BankAccountDto toDto(BankAccountEntity entity) {
        var bankAccountEntity = new BankAccountDto();
        bankAccountEntity.setBankAccountId(entity.getBankAccountId());
        bankAccountEntity.setBankAccountBalance(entity.getBankAccountBalance());
        bankAccountEntity.setCreatedTime(entity.getCreatedTime());
        return bankAccountEntity;
    }
}
