package com.dijitalmarketim.dijitalmarketimservice.client.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderResponse {

    private Long customerId;
    private LocalDateTime createDate;
    private OrderStatus orderStatus;
}
