package com.blinkspace.cursoSpring.repositories;

import com.blinkspace.cursoSpring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
