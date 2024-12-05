package com.example.hulk_store_backend.service.Implementation;

import com.example.hulk_store_backend.exception.CategoryNotFoundException;
import com.example.hulk_store_backend.model.Category;
import com.example.hulk_store_backend.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private Category category;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        category = new Category();
        category.setId(1L);
        category.setName("Test");
        category.setDescription("Test");
    }

    @Test
    void all() {
        when(categoryRepository.findAll()).thenReturn(Collections.singletonList(category));
        assertNotNull(categoryService.all());
    }

    @Test
    void findById() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.ofNullable(category));
        assertNotNull(categoryService.findById(1L));
    }

    @Test
    void findByIdNull() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(CategoryNotFoundException.class, () -> categoryService.findById(1L), "Category not found with ID: 1");
    }

    @Test
    void create() {
        when(categoryRepository.save(category)).thenReturn(category);
        assertNotNull(categoryService.create(category));
    }

    @Test
    void update(){
        when(categoryRepository.save(category)).thenReturn(category);
        assertThrows(CategoryNotFoundException.class, () -> categoryService.update(1L, category), "Category not found with ID: 1");
    }

    @Test
    void delete(){
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        String result = categoryService.delete(1L);
        String responseDelete = "Category successfully deleted";
        assertEquals(responseDelete, result);
    }
}