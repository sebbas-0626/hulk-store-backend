package com.example.hulk_store_backend.controller;


import com.example.hulk_store_backend.dto.ProductDTO;
import com.example.hulk_store_backend.service.Interface.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private IProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> all() {
        return new ResponseEntity<>(productService.all(), HttpStatus.OK);
    }
}
