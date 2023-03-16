package com.kelsonthony.payment.config.usecase;

import com.kelsonthony.payment.adapters.out.SavePaymentAdapter;
import com.kelsonthony.payment.adapters.out.SendToKafkaAdapter;
import com.kelsonthony.payment.adapters.out.UpdateUserAdapter;
import com.kelsonthony.payment.application.core.usecase.FindUserByIdUseCase;
import com.kelsonthony.payment.application.core.usecase.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUseCase salePaymentUseCase(
            FindUserByIdUseCase findUserByIdUseCase,
            UpdateUserAdapter updateUserAdapter,
            SavePaymentAdapter savePaymentAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ) {
        return new SalePaymentUseCase(findUserByIdUseCase, updateUserAdapter,
                savePaymentAdapter, sendToKafkaAdapter);
    }
}
