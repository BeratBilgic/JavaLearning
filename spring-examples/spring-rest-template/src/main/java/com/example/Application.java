package com.example;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private final ProductRepository productRepository;

    public Application(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setName("name 1");
        product.setBrand("brand 1");
        product.setPrice(50.0);
        productRepository.save(product);
    }
}
