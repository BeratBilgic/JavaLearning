package com.example.controller;

import com.example.dto.ProductDto;
import com.example.model.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/rc")
public class RestClientController {

    private static final String webUrlAll = "http://localhost:8080/product/all";
    private static final String webUrlFind = "http://localhost:8080/product/find/{id}";
    private static final String webUrlCreate = "http://localhost:8080/product/create";

    private final RestTemplate restTemplate;

    public RestClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ProductDto>> findAll(){
        //ResponseEntity<List> result = restTemplate.getForEntity(webUrlAll, List.class);
        ResponseEntity<List> result = restTemplate.exchange(webUrlAll, HttpMethod.GET, null, List.class);
        List<ProductDto> responseBody = result.getBody();
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id){
        //ProductDto responseEntity =
        //        restTemplate.getForObject(webUrlFind, ProductDto.class, Map.of("id", id));
        ResponseEntity<ProductDto> responseEntity =
                restTemplate.getForEntity(webUrlFind, ProductDto.class, Map.of("id", id));
        return responseEntity;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto){
        HttpEntity<ProductDto> request = new HttpEntity<>(productDto);
        //ResponseEntity<ProductDto> result = restTemplate.postForEntity(webUrlCreate, request, ProductDto.class);
        ResponseEntity<ProductDto> result = restTemplate.exchange(webUrlCreate, HttpMethod.POST, request, ProductDto.class);

        return result;
    }
}
