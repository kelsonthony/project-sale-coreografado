package com.kelsonthony.sale.application.ports.out;

import com.kelsonthony.sale.application.core.domain.Sale;
import com.kelsonthony.sale.application.core.domain.enums.SaleEvent;

public interface SendCreateSalveOutputPort {

    void send(Sale sale, SaleEvent event);
}
