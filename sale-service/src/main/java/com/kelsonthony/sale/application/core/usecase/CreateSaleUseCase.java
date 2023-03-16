package com.kelsonthony.sale.application.core.usecase;

import com.kelsonthony.sale.application.core.domain.Sale;
import com.kelsonthony.sale.application.core.domain.enums.SaleEvent;
import com.kelsonthony.sale.application.core.domain.enums.SaleStatus;
import com.kelsonthony.sale.application.ports.in.CreateSaleInputPort;
import com.kelsonthony.sale.application.ports.out.SaveSaleOutputPort;
import com.kelsonthony.sale.application.ports.out.SendCreateSalveOutputPort;

public class CreateSaleUseCase implements CreateSaleInputPort {

    private final SaveSaleOutputPort saveSaleOutputPort;

    private final SendCreateSalveOutputPort sendCreateSalveOutputPort;

    public CreateSaleUseCase(
            SaveSaleOutputPort saveSaleOutputPort,
            SendCreateSalveOutputPort sendCreateSalveOutputPort) {
        this.saveSaleOutputPort = saveSaleOutputPort;
        this.sendCreateSalveOutputPort = sendCreateSalveOutputPort;
    }

    @Override
    public void create(Sale sale) {
        sale.setStatus(SaleStatus.PENDING);
        var saleResponse = saveSaleOutputPort.save(sale);
        sendCreateSalveOutputPort.send(saleResponse, SaleEvent.CREATED_SALE);

    }
}
