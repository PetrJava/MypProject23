package paymentsSystem.service;


import paymentsSystem.dao.PaymentActionDao;
import paymentsSystem.dto.ClientDto;
import paymentsSystem.dto.PaymentActionDto;
import paymentsSystem.entity.PaymentActionEntity;
import paymentsSystem.mapper.MapperToDto;
import paymentsSystem.mapper.PaymentActionMapperToDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PaymentActionService {
    public PaymentActionService() {
    }

    private final MapperToDto<PaymentActionEntity, PaymentActionDto> paymentMapper = new PaymentActionMapperToDto();
    private static final PaymentActionService INSTANCE = new PaymentActionService();
    private final PaymentActionDao paymentActionDao = PaymentActionDao.getInstance();

    public static PaymentActionService getInstance() {
        return INSTANCE;
    }

    public List<PaymentActionDto> findAll() {
        return paymentActionDao.findAll().stream()
                .map(paymentMapper::toDto)
                .collect(toList());
    }
}
