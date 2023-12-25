package paymentsSystem.service;

import paymentsSystem.dao.CreditCardDao;
import paymentsSystem.dto.CreditCardDto;
import paymentsSystem.entity.CreditCardEntity;
import paymentsSystem.mapper.MapperToDto;
import paymentsSystem.mapper.CreditCardMapperToDto;

public class CreditCardService  {
    public CreditCardService() {
    }
    private final MapperToDto<CreditCardEntity, CreditCardDto> creditCardMapper = new CreditCardMapperToDto();
    private static final CreditCardService INSTANCE = new CreditCardService();
    private final CreditCardDao creditCardDao = CreditCardDao.getInstance();

    public static CreditCardService getInstance() {
        return INSTANCE;
    }

}
