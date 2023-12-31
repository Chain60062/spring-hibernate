package com.vinicius.springudemy.config;

import java.util.Arrays;
import java.time.Instant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vinicius.springudemy.entities.Category;
import com.vinicius.springudemy.entities.Order;
import com.vinicius.springudemy.entities.OrderItem;
import com.vinicius.springudemy.entities.Payment;
import com.vinicius.springudemy.entities.Product;
import com.vinicius.springudemy.entities.User;
import com.vinicius.springudemy.entities.enums.OrderStatus;
import com.vinicius.springudemy.repositories.CategoryRepository;
import com.vinicius.springudemy.repositories.OrderItemRepository;
import com.vinicius.springudemy.repositories.OrderRepository;
import com.vinicius.springudemy.repositories.ProductRepository;
import com.vinicius.springudemy.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private UserRepository userRepository;

    private OrderRepository orderRepository;

    private CategoryRepository categoryRepository;

    private ProductRepository productRepository;

    private OrderItemRepository orderItemRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository,
            CategoryRepository categoryRepository, ProductRepository productRepository,
            OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        var u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        var u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        var o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        var o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2);
        var o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);

        var cat1 = new Category(null, "Electronics");
        var cat2 = new Category(null, "Books");
        var cat3 = new Category(null, "Computers");

        var p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        var p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        var p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        var p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        var p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        var oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        var oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        var oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        var oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        // categories deve existir no bd antes que se possa realizar relacoes com product
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        p1.AddCategory(cat1);
        p1.AddCategory(cat2);
        p2.AddCategory(cat3);
        p3.AddCategory(cat1);
        p3.AddCategory(cat2);
        p3.AddCategory(cat3);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        var pay1 = new Payment(null, Instant.parse("2019-06-20T23:53:07Z"), o1);

        o1.setPayment(pay1);
        orderRepository.save(o1);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}
