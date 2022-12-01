package com.blinkspace.cursoSpring.repositories;

import com.blinkspace.cursoSpring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
