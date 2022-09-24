package com.order.api.messaging;

import com.order.api.dto.DeliveryInformationDto;
import org.springframework.stereotype.Component;

@Component
public interface MessageSender {
    String send(DeliveryInformationDto information);
}
