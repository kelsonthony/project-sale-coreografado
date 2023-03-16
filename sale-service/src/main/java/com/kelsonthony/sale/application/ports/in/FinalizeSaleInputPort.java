package com.kelsonthony.sale.application.ports.in;

import com.kelsonthony.sale.application.core.domain.Sale;

public interface FinalizeSaleInputPort {

    void finalize(Sale sale);
}
