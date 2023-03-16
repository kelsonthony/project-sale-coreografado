package com.kelsonthony.inventory.application.ports.out;

import com.kelsonthony.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void update(Inventory inventory);
}
