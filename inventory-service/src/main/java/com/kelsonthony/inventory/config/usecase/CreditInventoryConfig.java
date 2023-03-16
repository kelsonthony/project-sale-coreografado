package com.kelsonthony.inventory.config.usecase;

import com.kelsonthony.inventory.adapters.out.SendToKafkaAdapter;
import com.kelsonthony.inventory.adapters.out.UpdateInventoryAdapter;
import com.kelsonthony.inventory.application.core.usecase.CreditInventoryUseCase;
import com.kelsonthony.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import com.kelsonthony.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.kelsonthony.inventory.application.ports.out.SendToKafkaOutputPort;
import com.kelsonthony.inventory.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryConfig {

    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ) {
    return new CreditInventoryUseCase(findInventoryByProductIdUseCase,
            updateInventoryAdapter, sendToKafkaAdapter);
    }

}
