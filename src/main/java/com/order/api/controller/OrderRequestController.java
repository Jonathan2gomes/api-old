package com.order.api.controller;

import com.order.api.dto.OrderRequestDto;
import com.order.api.model.Order;
import com.order.api.service.OrderRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRequestController {

    @Autowired
    private OrderRequestService orderRequestService;

    @PostMapping("/Order/{id}")
    public ResponseEntity saveOrder(@RequestBody OrderRequestDto incomingOrder){

        return ResponseEntity.ok( orderRequestService.saveOrder(incomingOrder));
    }

}
