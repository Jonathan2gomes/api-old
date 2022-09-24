package com.order.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class OrderUser {

    @Id
    private Long userId;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String documentNumber;

    @Column
    @OneToOne
    private Address address;
}
