package com.kelsonthony.sale.adapters.out.message;

import com.kelsonthony.sale.application.core.domain.Sale;
import com.kelsonthony.sale.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SaleMessage {

    private Sale sale;
    private SaleEvent event;
}
