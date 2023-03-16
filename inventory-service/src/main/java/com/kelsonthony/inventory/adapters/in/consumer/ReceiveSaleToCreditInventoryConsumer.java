package com.kelsonthony.inventory.adapters.in.consumer;

import com.kelsonthony.inventory.adapters.out.message.SaleMessage;
import com.kelsonthony.inventory.application.core.domain.enums.SaleEvent;
import com.kelsonthony.inventory.application.ports.in.CreditInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToCreditInventoryConsumer {

    @Autowired
    private CreditInventoryInputPort creditInventoryInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-credit")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.FAILED_PAYMENT.equals(saleMessage.getEvent())) {
            log.info("Inicio da devolução da mercadoria");
            creditInventoryInputPort.credit(saleMessage.getSale());
            log.info("Fim da devolução da mercadoria");
        }
    }
}
