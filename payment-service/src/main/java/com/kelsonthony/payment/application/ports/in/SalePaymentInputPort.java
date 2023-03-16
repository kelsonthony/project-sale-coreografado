package com.kelsonthony.payment.application.ports.in;

import com.kelsonthony.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {

    void payment(Sale sale);
}
