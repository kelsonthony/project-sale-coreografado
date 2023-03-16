package com.kelsonthony.sale.config.usecase;

import com.kelsonthony.sale.adapters.out.FindSaleByIdAdapter;
import com.kelsonthony.sale.application.core.usecase.FindSaleByIdUseCase;
import com.kelsonthony.sale.application.ports.out.FindSaleByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSaleByIdConfig {
    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(
            FindSaleByIdAdapter findSaleByIdAdapter
    ) {
        return new FindSaleByIdUseCase(findSaleByIdAdapter);
    }
}
