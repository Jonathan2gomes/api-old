package com.order.api.repository;

import com.order.api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRequestRepository extends JpaRepository<Order, Long> {
}
