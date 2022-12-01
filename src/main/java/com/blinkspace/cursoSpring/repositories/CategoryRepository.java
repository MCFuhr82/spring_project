package com.blinkspace.cursoSpring.repositories;

import com.blinkspace.cursoSpring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
