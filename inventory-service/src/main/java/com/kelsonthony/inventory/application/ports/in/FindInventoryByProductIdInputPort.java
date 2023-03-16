package com.kelsonthony.inventory.application.ports.in;

import com.kelsonthony.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory find(Integer productId);
}
