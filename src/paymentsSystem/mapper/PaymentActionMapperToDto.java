package paymentsSystem.mapper;

import paymentsSystem.dto.PaymentActionDto;
import paymentsSystem.entity.PaymentActionEntity;

public class PaymentActionMapperToDto implements MapperToDto<PaymentActionEntity, PaymentActionDto> {
    @Override
    public PaymentActionDto toDto(PaymentActionEntity entity) {
        var payment = new PaymentActionDto();
        payment.setPaymentActionId(entity.getTypeOperationEntity().getTypeOperationId());
        payment.setDateAndTime(entity.getDateAndTime());
        payment.setTransactionAmount(entity.getTransactionAmount());
        payment.setTransactionFrom(entity.getBankAccountEntityFrom().getBankAccountId());
        payment.setTransactionTo(entity.getBankAccountEntityTo().getBankAccountId());
        payment.setStatus(entity.getStatus());
        payment.setPaymentActionNo(entity.getPaymentActionNo());
        return payment;
    }
}
