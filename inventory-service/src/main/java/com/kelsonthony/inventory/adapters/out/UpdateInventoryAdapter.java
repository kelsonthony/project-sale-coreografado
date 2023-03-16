package com.kelsonthony.inventory.adapters.out;

import com.kelsonthony.inventory.adapters.out.repository.InventoryRepository;
import com.kelsonthony.inventory.adapters.out.repository.entity.InventoryEntity;
import com.kelsonthony.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.kelsonthony.inventory.application.core.domain.Inventory;
import com.kelsonthony.inventory.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryEntityMapper inventoryEntityMapper;
    @Override
    public void update(Inventory inventory) {
        InventoryEntity inventoryEntity = inventoryEntityMapper.toInventoryEntity(inventory);
        inventoryRepository.save(inventoryEntity);
    }
}
