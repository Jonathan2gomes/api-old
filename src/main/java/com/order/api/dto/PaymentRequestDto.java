package com.order.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentRequestDto {

    private String cardNumber;
    private String cardName;
    private String cvv;
    private String documentNumber;
    private String name;
    private Double productPrice;

}
