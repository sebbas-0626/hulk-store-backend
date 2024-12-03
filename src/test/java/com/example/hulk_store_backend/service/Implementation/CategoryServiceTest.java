package com.example.hulk_store_backend.service.Implementation;

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
import static org.mockito.Mockito.when;

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
        assertNull(categoryService.findById(1L));
    }
}