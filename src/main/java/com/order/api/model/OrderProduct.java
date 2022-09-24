package com.order.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class OrderProduct {

    @Id
    private Long productId;

    @Column
    private String productName;

    @Column
    private Double productPrice;
}
