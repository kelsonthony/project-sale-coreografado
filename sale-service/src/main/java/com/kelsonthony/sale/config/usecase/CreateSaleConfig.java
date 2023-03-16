package com.kelsonthony.sale.config.usecase;

import com.kelsonthony.sale.adapters.out.SaveSaleAdapter;
import com.kelsonthony.sale.adapters.out.SendCreateSaleAdapter;
import com.kelsonthony.sale.application.core.usecase.CreateSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSaleConfig {

    @Bean
    public CreateSaleUseCase createSaleUseCase(
        SaveSaleAdapter saveSaleAdapter,
        SendCreateSaleAdapter sendCreateSaleAdapter
    ) {
        return new CreateSaleUseCase(saveSaleAdapter, sendCreateSaleAdapter);
    }
}
