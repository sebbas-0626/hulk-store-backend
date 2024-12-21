package com.example.hulk_store_backend.service.Implementation;

import com.example.hulk_store_backend.dto.CategoryDTO;
import com.example.hulk_store_backend.exception.OperationException;
import com.example.hulk_store_backend.exception.ResourceNotFoundException;
import com.example.hulk_store_backend.model.Category;
import com.example.hulk_store_backend.repository.CategoryRepository;
import com.example.hulk_store_backend.service.Interface.ICategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CategoryDTO> all() {
        return this.categoryRepository.findAll().stream().map(category -> this.modelMapper.map(category, CategoryDTO.class)).toList();
    }


    @Override
    public CategoryDTO findById(Long id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return this.modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public Category create(Category category) {
        try {
            return categoryRepository.save(category);
        } catch (Exception e) {
            throw new OperationException("Error creating : " + e.getMessage());
        }
    }

    @Override
    public Category update(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public String delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        categoryRepository.delete(category);
        return "Category deleted successfully";
    }
}
