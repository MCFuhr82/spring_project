package com.blinkspace.cursoSpring.config;

import com.blinkspace.cursoSpring.entities.Order;
import com.blinkspace.cursoSpring.entities.User;
import com.blinkspace.cursoSpring.entities.enums.OrderStatus;
import com.blinkspace.cursoSpring.repositories.OrderRepository;
import com.blinkspace.cursoSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Marcelo Fuhr", "marcelo@gmail.com", "9999999", "12345");
        User u2 = new User(null, "Rodrigo Fuhr", "rodrigo@gmail.com", "9999999", "12345");

        Order o1 = new Order(null, Instant.parse("2022-11-15T15:23:25Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2022-11-20T15:23:25Z"), OrderStatus.DELIVERED, u2);
        Order o3 = new Order(null, Instant.parse("2022-11-25T15:23:25Z"), OrderStatus.SHIPPED, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
