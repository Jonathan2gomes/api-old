package com.order.api.service;

import com.order.api.client.CreditCardValidator;
import com.order.api.dto.DeliveryInformationDto;
import com.order.api.dto.OrderRequestDto;
import com.order.api.dto.PaymentRequestDto;
import com.order.api.mapper.OrderMapper;
import com.order.api.messaging.MessageSender;
import com.order.api.model.Order;
import com.order.api.repository.OrderRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRequestService {

    @Autowired
    OrderRequestRepository orderRequestRepository;

    @Autowired
    CreditCardValidator creditCardValidator;

    @Autowired
    MessageSender sender;

    private final OrderMapper mapper;

    public OrderRequestService(OrderMapper mapper) {
        this.mapper = mapper;
    }

    public String saveOrder(OrderRequestDto incomingOrder) {

        Order newOrder = mapper.fromOrderDtoToOrder(incomingOrder);

        orderRequestRepository.save(newOrder);

        PaymentRequestDto creditCardValidationRequest = mapper.convertToCreditCardValidator(newOrder);

        ResponseEntity<String> validation = creditCardValidator.getValidation(creditCardValidationRequest);

        newOrder.setOrderStatus(validation.getBody());

        orderRequestRepository.save(newOrder);

        if (validation.getBody() != null && validation.getStatusCode() == HttpStatus.OK && validation.getBody().equals("valido")) {
            //Manda pra fila
            DeliveryInformationDto deliveryInformationDto = mapper.convertToDeliveryInformationDto(newOrder);
            sender.send(deliveryInformationDto);
            return "Pedido efetuado com sussessosososo";
        }
        else {
            return "Pedido não efetuado";
        }
    }
}
