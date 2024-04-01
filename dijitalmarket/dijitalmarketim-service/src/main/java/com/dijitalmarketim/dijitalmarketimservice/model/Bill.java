package com.dijitalmarketim.dijitalmarketimservice.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
public class Bill {

    private Long billId;
    private LocalDate billDate;
    private Double totalPrice;
    private Order order;

    private Bill() {
    
    }
    
    private Bill(Long billId, LocalDate billDate, Double totalPrice, Order order) {
        this.billId = billId;
        this.billDate = billDate;
        this.totalPrice = totalPrice;
        this.order = order;
    
    }
}
