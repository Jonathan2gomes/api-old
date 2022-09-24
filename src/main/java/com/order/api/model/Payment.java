package com.order.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Payment {

    @Id
    private String id;

    @Column
    private String cardNumber;

    @Column
    private String cardName;

    @Column
    private String cvv;
}
