package com.example.hulk_store_backend.controller;

import com.example.hulk_store_backend.dto.CategoryDTO;
import com.example.hulk_store_backend.model.Category;
import com.example.hulk_store_backend.service.Interface.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    //    @GetMapping()
//    public ResponseEntity<List<Category>> all() {
//        return new ResponseEntity<>(this.categoryService.all(), HttpStatus.OK);
//    }
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> all() {
        return new ResponseEntity<>(categoryService.all(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.categoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return new ResponseEntity<>(this.categoryService.create(category), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
        return new ResponseEntity<>(this.categoryService.update(id, category), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(this.categoryService.delete(id), HttpStatus.OK);
    }

}
