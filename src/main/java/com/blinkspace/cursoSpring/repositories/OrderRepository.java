package com.blinkspace.cursoSpring.repositories;

import com.blinkspace.cursoSpring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
