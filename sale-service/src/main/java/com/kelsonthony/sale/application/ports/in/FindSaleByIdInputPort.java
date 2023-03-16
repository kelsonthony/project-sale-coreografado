package com.kelsonthony.sale.application.ports.in;

import com.kelsonthony.sale.application.core.domain.Sale;

public interface FindSaleByIdInputPort {
    Sale find(final Integer id);
}
