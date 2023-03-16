package com.kelsonthony.payment.application.ports.out;

import com.kelsonthony.payment.application.core.domain.Sale;
import com.kelsonthony.payment.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent saleEvent);
}
