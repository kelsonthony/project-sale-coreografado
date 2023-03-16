package com.kelsonthony.sale.config.usecase;

import com.kelsonthony.sale.adapters.out.SaveSaleAdapter;
import com.kelsonthony.sale.application.core.usecase.CancelSaleUseCase;
import com.kelsonthony.sale.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleUseCase cancelSaleUseCase(
            FindSaleByIdUseCase findSaleByIdUseCase,
            SaveSaleAdapter saveSaleAdapter
    ) {
        return new CancelSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }
}
