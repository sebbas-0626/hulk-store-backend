package com.example.hulk_store_backend.service.Interface;

import com.example.hulk_store_backend.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> all();
    Category findById(Long id);
    Category create(Category category);
    Category update(Long id, Category category);
}
