package com.example.hulk_store_backend.service.Implementation;


import com.example.hulk_store_backend.dto.ProductDTO;
import com.example.hulk_store_backend.exception.OperationException;
import com.example.hulk_store_backend.exception.ResourceNotFoundException;
import com.example.hulk_store_backend.model.Category;
import com.example.hulk_store_backend.model.Product;
import com.example.hulk_store_backend.repository.CategoryRepository;
import com.example.hulk_store_backend.repository.ProductRepository;
import com.example.hulk_store_backend.service.Interface.IProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ProductService implements IProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository; // Inyección del repositorio correcto

    @Override
    public List<ProductDTO> all() {
        return this.productRepository.findAll().stream()
                .map(product -> this.modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return this.modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        try {
            Category category = categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException(productDTO.getCategoryId()));
            Product product = this.modelMapper.map(productDTO, Product.class);
            product.setCategory(category);
            Product savedProduct = productRepository.save(product);
            return this.modelMapper.map(savedProduct, ProductDTO.class);
        }
    }


    @Override
    public Product update(Long id, Product product)
            {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        existingProduct.setImageUrl(product.getImageUrl());
        existingProduct.setStatus(product.getStatus());
        existingProduct.setCategory(product.getCategory());
        return productRepository.save(existingProduct);
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
