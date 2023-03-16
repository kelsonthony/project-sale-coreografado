package com.kelsonthony.sale.application.ports.out;

import com.kelsonthony.sale.application.core.domain.Sale;

public interface SaveSaleOutputPort {
    Sale save(Sale sale);
}
