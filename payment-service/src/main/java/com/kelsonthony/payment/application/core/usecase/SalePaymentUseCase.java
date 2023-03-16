package com.kelsonthony.payment.application.core.usecase;

import com.kelsonthony.payment.application.core.domain.Payment;
import com.kelsonthony.payment.application.core.domain.Sale;
import com.kelsonthony.payment.application.core.domain.enums.SaleEvent;
import com.kelsonthony.payment.application.ports.in.FindUserByIdInputPort;
import com.kelsonthony.payment.application.ports.in.SalePaymentInputPort;
import com.kelsonthony.payment.application.ports.out.SavePaymentOutputPort;
import com.kelsonthony.payment.application.ports.out.SendToKafkaOutputPort;
import com.kelsonthony.payment.application.ports.out.UpdateUserOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SalePaymentUseCase implements SalePaymentInputPort {

    private final FindUserByIdInputPort findUserByIdOnputPort;

    private final UpdateUserOutputPort updateUserOutputPort;

    private final SavePaymentOutputPort savePaymentOutputPort;

    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public SalePaymentUseCase(FindUserByIdInputPort findUserByIdOnputPort,
                              UpdateUserOutputPort updateUserOutputPort,
                              SavePaymentOutputPort savePaymentOutputPort,
                              SendToKafkaOutputPort sendToKafkaOutputPort) {
        this.findUserByIdOnputPort = findUserByIdOnputPort;
        this.updateUserOutputPort = updateUserOutputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }

    @Override
    public void payment(Sale sale) {
        try {
            var user = findUserByIdOnputPort.find(sale.getUserId());
            if (user.getBalance().compareTo(sale.getValue()) < 0) {
                throw new RuntimeException("Saldo insuficiente");
            }
            user.debitBalance(sale.getValue());
            updateUserOutputPort.update(user);
            savePaymentOutputPort.save(buildPayment(sale));
            sendToKafkaOutputPort.send(sale, SaleEvent.VALIDATED_PAYMENT);
        } catch (Exception e) {
            log.error("Houve um erro = {}", e.getMessage());
            sendToKafkaOutputPort.send(sale, SaleEvent.FAILED_PAYMENT);
        }
    }

    private Payment buildPayment(Sale sale) {
        return new Payment(null, sale.getUserId(), sale.getId(), sale.getValue());
    }
}
