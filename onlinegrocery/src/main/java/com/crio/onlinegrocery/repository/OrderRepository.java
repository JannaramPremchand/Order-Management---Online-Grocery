package com.crio.onlinegrocery.repository;

import com.crio.onlinegrocery.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
