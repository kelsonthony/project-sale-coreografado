package com.kelsonthony.inventory.adapters.out;

import com.kelsonthony.inventory.adapters.out.message.SaleMessage;
import com.kelsonthony.inventory.application.core.domain.Sale;
import com.kelsonthony.inventory.application.core.domain.enums.SaleEvent;
import com.kelsonthony.inventory.application.ports.out.SendToKafkaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendToKafkaAdapter implements SendToKafkaOutputPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;
    @Override
    public void send(Sale sale, SaleEvent event) {
        SaleMessage saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
