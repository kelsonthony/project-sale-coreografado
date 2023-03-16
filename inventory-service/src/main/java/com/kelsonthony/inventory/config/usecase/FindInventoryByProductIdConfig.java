package com.kelsonthony.inventory.config.usecase;

import com.kelsonthony.inventory.adapters.out.FindInventoryByProductIdAdapter;
import com.kelsonthony.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindInventoryByProductIdConfig {

    @Bean
    public FindInventoryByProductIdUseCase findInventoryByProductIdUseCase(
            FindInventoryByProductIdAdapter findInventoryByProductIdAdapter
    ) {
        return new FindInventoryByProductIdUseCase(findInventoryByProductIdAdapter);
    }
}
