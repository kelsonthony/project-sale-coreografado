package com.kelsonthony.sale.config.usecase;

import com.kelsonthony.sale.adapters.out.SaveSaleAdapter;
import com.kelsonthony.sale.application.core.usecase.FinalizeSaleUseCase;
import com.kelsonthony.sale.application.core.usecase.FindSaleByIdUseCase;
import com.kelsonthony.sale.application.ports.in.FindSaleByIdInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinalizeSaleConfig {

    @Bean
    public FinalizeSaleUseCase finalizeSaleUseCase(
            FindSaleByIdUseCase findSaleByIdUseCase,
            SaveSaleAdapter saveSaleAdapter
    ) {
        return new FinalizeSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }
}
