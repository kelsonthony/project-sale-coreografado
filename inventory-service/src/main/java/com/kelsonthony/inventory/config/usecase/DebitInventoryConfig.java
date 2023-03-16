package com.kelsonthony.inventory.config.usecase;

import com.kelsonthony.inventory.adapters.out.SendToKafkaAdapter;
import com.kelsonthony.inventory.adapters.out.UpdateInventoryAdapter;
import com.kelsonthony.inventory.application.core.usecase.DebitInventoryUseCase;
import com.kelsonthony.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInventoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendToKafkaAdapter sendToKafkaAdapter

    ) {
        return new DebitInventoryUseCase(findInventoryByProductIdUseCase,
                updateInventoryAdapter, sendToKafkaAdapter);
    }
}
