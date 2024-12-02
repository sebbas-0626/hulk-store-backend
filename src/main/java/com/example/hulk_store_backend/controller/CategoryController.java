package com.example.hulk_store_backend.controller;

import com.example.hulk_store_backend.model.Category;
import com.example.hulk_store_backend.service.Interface.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> all() {
        return new ResponseEntity<>(this.categoryService.all(), HttpStatus.OK);
    }

}
