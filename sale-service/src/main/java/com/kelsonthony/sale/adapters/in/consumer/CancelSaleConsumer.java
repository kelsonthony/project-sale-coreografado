package com.kelsonthony.sale.adapters.in.consumer;

import com.kelsonthony.sale.adapters.out.message.SaleMessage;
import com.kelsonthony.sale.application.core.domain.enums.SaleEvent;
import com.kelsonthony.sale.application.ports.in.CancelSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CancelSaleConsumer {

    @Autowired
    private CancelSaleInputPort cancelSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-cancel")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.ROLLBACK_INVENTORY.equals(saleMessage.getEvent())) {
            log.info("Cancelado a venda...");
            cancelSaleInputPort.cancel(saleMessage.getSale());
            log.info("Venda cancelada com sucesso.");
        }
    }
}
