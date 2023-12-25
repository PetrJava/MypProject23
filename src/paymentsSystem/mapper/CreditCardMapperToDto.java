package paymentsSystem.mapper;

import paymentsSystem.dto.CreditCardDto;
import paymentsSystem.entity.CreditCardEntity;

public class CreditCardMapperToDto implements MapperToDto<CreditCardEntity, CreditCardDto> {
    @Override
    public CreditCardDto toDto(CreditCardEntity entity) {
        var creditCardEntity = new CreditCardDto();
        creditCardEntity.setCardId(entity.getBankAccountEntity().getBankAccountId());
        creditCardEntity.setCardNo(entity.getCardNo());
        creditCardEntity.setCreditCardBalance(entity.getCreditCardBalance());
        creditCardEntity.setCreatedTime(entity.getCreatedTime());
        creditCardEntity.setExpireDate(entity.getExpireDate());
        return creditCardEntity;
    }


}
