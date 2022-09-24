package com.order.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class OrderRequestDto {

    private UserDto user;
    private List<OrderProductDto> products;
    private PaymentDto payment;
    private String orderStatus;

}
