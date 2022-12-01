package com.blinkspace.cursoSpring.config;

import com.blinkspace.cursoSpring.entities.Category;
import com.blinkspace.cursoSpring.entities.Order;
import com.blinkspace.cursoSpring.entities.Product;
import com.blinkspace.cursoSpring.entities.User;
import com.blinkspace.cursoSpring.entities.enums.OrderStatus;
import com.blinkspace.cursoSpring.repositories.CategoryRepository;
import com.blinkspace.cursoSpring.repositories.OrderRepository;
import com.blinkspace.cursoSpring.repositories.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Marcelo Fuhr", "marcelo@gmail.com", "9999999", "12345");
        User u2 = new User(null, "Rodrigo Fuhr", "rodrigo@gmail.com", "9999999", "12345");

        Order o1 = new Order(null, Instant.parse("2022-11-15T15:23:25Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2022-11-20T15:23:25Z"), OrderStatus.DELIVERED, u2);
        Order o3 = new Order(null, Instant.parse("2022-11-25T15:23:25Z"), OrderStatus.SHIPPED, u1);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
