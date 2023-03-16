package com.kelsonthony.payment.adapters.out;

import com.kelsonthony.payment.adapters.out.repository.PaymentRepository;
import com.kelsonthony.payment.adapters.out.repository.mapper.PaymentEntityMapper;
import com.kelsonthony.payment.application.core.domain.Payment;
import com.kelsonthony.payment.application.ports.out.SavePaymentOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePaymentAdapter implements SavePaymentOutputPort {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentEntityMapper paymentEntityMapper;

    @Override
    public void save(Payment payment) {
        var paymentEntity = paymentEntityMapper.toPaymentEntity(payment);
        paymentRepository.save(paymentEntity);
    }
}
