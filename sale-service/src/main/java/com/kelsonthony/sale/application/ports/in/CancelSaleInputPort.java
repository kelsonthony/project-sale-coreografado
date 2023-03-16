package com.kelsonthony.sale.application.ports.in;

import com.kelsonthony.sale.application.core.domain.Sale;

public interface CancelSaleInputPort {

    void cancel(Sale sale);
}
