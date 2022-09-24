package com.order.api.client;

import com.order.api.dto.PaymentRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("url-creditcard-validator")
public interface CreditCardValidator {

    @PostMapping("¹validate")
    ResponseEntity<String> getValidation(@RequestBody PaymentRequestDto payment);
}
