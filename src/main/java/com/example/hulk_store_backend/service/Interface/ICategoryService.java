package com.example.hulk_store_backend.service.Interface;

import com.example.hulk_store_backend.dto.CategoryDTO;
import com.example.hulk_store_backend.model.Category;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> all();
    CategoryDTO findById(Long id);
    CategoryDTO create(Category category);
    CategoryDTO update(Long id, Category category);
    String delete(Long id);
}
