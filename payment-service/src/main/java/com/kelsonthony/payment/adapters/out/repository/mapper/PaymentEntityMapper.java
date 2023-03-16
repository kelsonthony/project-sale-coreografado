package com.kelsonthony.payment.adapters.out.repository.mapper;

import com.kelsonthony.payment.adapters.out.repository.entity.PaymentEntity;
import com.kelsonthony.payment.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

    PaymentEntity toPaymentEntity(Payment payment);
}
