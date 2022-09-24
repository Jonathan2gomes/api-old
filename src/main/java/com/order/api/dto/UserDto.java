package com.order.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDto {

    private String Name;
    private String email;
    private AddressDto address;
    private String documentNumber;
}
