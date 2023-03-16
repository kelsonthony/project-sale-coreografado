package com.kelsonthony.inventory.adapters.out;

import com.kelsonthony.inventory.adapters.out.repository.InventoryRepository;
import com.kelsonthony.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.kelsonthony.inventory.application.core.domain.Inventory;
import com.kelsonthony.inventory.application.ports.out.FindInventoryByProductIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryEntityMapper inventoryEntityMapper;
    @Override
    public Optional<Inventory> find(Integer productId) {
        var inventoryEntity = inventoryRepository.findByProductId(productId);
        return inventoryEntity.map(entity -> inventoryEntityMapper.toInventory(entity));
    }
}
