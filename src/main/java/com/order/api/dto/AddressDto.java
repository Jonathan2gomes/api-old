package com.order.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
@AllArgsConstructor
public class AddressDto {

    private String cep;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String bairro;
}
