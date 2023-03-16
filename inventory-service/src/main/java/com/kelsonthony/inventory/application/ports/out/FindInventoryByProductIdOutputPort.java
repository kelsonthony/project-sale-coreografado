package com.kelsonthony.inventory.application.ports.out;

import com.kelsonthony.inventory.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutputPort {

    Optional<Inventory> find(final Integer productId);
}
