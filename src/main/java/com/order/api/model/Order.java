package com.order.api.model;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    private Long transactionId;

    @OneToOne
    private OrderUser orderUser;

    @OneToMany
    @ToString.Exclude
    private List<OrderProduct> products;

    @OneToOne
    private Payment payment;

    @Column
    private String orderStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;
        return transactionId != null && Objects.equals(transactionId, order.transactionId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
