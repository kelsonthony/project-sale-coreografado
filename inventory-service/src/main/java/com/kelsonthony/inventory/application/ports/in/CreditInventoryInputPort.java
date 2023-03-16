package com.kelsonthony.inventory.application.ports.in;

import com.kelsonthony.inventory.application.core.domain.Sale;

public interface CreditInventoryInputPort {

    void credit(Sale sale);
}
