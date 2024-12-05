package com.example.hulk_store_backend.service.Implementation;

import com.example.hulk_store_backend.exception.CategoryNotFoundException;
import com.example.hulk_store_backend.exception.CategoryOperationException;
import com.example.hulk_store_backend.model.Category;
import com.example.hulk_store_backend.repository.CategoryRepository;
import com.example.hulk_store_backend.service.Interface.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> all() {
        return this.categoryRepository.findAll();
    }

//    @Override
//    public Category findById(Long id) {
//        return this.categoryRepository.findById(id).orElseGet(()->null);
//    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id)); // Lanza excepción si no encuentra
    }

//    @Override
//    public Category create(Category category) {
//        return this.categoryRepository.save(category);
//    }

@Override
public Category create(Category category) {
    try {
        return categoryRepository.save(category);
    } catch (Exception e) {
        throw new CategoryOperationException("Error al crear la categoría: " + e.getMessage());
    }
}


    @Override
    public Category update(Long id, Category category) {
        Category categoryEntity = findById(id);
        if (categoryEntity == null) return null;
        categoryEntity.setName(category.getName());
        categoryEntity.setDescription(category.getDescription());
        return this.categoryRepository.save(categoryEntity);
    }

    @Override
    public String delete(Long id) {
        Category category = findById(id);
        if (category == null) return "The category does not exist";
        this.categoryRepository.delete(category);
        return "Category successfully deleted";
    }
}
