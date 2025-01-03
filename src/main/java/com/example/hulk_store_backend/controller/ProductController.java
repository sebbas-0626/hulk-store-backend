package com.example.hulk_store_backend.controller;


import com.example.hulk_store_backend.dto.ProductDTO;
import com.example.hulk_store_backend.service.Interface.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.productService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(this.productService.create(product), HttpStatus.CREATED);

    }
}
