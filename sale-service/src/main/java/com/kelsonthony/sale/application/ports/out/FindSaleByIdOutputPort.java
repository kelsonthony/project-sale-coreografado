package com.kelsonthony.sale.application.ports.out;

import com.kelsonthony.sale.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {

    Optional<Sale> find(final Integer id);
}
