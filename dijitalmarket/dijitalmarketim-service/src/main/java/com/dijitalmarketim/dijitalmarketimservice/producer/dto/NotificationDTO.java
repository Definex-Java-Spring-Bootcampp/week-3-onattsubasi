package com.dijitalmarketim.dijitalmarketimservice.producer.dto;

import com.dijitalmarketim.dijitalmarketimservice.producer.enums.NotificationType;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NotificationDTO {

    private NotificationType notificationType;
    private String message;
    private String email;

}
