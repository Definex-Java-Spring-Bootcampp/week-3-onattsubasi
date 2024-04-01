package com.dijitalmarketim.dijitalmarketimservice.producer;

import com.dijitalmarketim.dijitalmarketimservice.configuration.RabbitMQConfiguration;
import com.dijitalmarketim.dijitalmarketimservice.producer.dto.NotificationDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {

    // private final RabbitTemplate rabbitTemplate;

    private final RabbitMQConfiguration rabbitMQConfiguration;
    private final AmqpTemplate amqpTemplate;

    public void sendNotification(NotificationDTO notificationDTO) {
        log.info("notification sent: {}", notificationDTO);
        amqpTemplate.convertSendAndReceive(rabbitMQConfiguration.getExchange(), rabbitMQConfiguration.getRoutingkey(), notificationDTO);
    }

}