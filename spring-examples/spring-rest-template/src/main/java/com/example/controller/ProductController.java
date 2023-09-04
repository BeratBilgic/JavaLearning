package com.example.controller;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok(productRepository.findById(id).get());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Product> create(@RequestBody Product product){
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }
}
