package com.kelsonthony.payment.application.ports.out;

import com.kelsonthony.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {

    void save(Payment payment);
}
