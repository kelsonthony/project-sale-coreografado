package com.kelsonthony.inventory.application.ports.out;

import com.kelsonthony.inventory.application.core.domain.Sale;
import com.kelsonthony.inventory.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {
    void send(Sale sale, SaleEvent event);
}
