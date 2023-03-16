package com.kelsonthony.sale.adapters.out;

import com.kelsonthony.sale.adapters.out.message.SaleMessage;
import com.kelsonthony.sale.application.core.domain.Sale;
import com.kelsonthony.sale.application.core.domain.enums.SaleEvent;
import com.kelsonthony.sale.application.ports.out.SendCreateSalveOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCreateSaleAdapter implements SendCreateSalveOutputPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;
    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
