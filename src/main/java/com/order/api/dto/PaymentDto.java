package com.order.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PaymentDto {

    private String cardNumber;
    private String cardName;
    private String cvv;
}
