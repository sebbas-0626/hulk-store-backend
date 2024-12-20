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
    public Category findById(Long id) {
        return this.categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public CategoryDTO findBiId(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return modelMapper.map(category,CategoryDTO.class);
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
        Category categoryEntity = findById(id);
        if (categoryEntity == null) return null;
        categoryEntity.setName(category.getName());
        categoryEntity.setDescription(category.getDescription());
        return this.categoryRepository.save(categoryEntity);
    }

    @Override
    public String delete(Long id) {
        Category category = findById(id);
        if (category == null) return "The does not exist";
        this.categoryRepository.delete(category);
        return "successfully deleted";
    }
}
