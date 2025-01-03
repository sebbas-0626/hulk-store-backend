package com.example.hulk_store_backend.service.Implementation;


import com.example.hulk_store_backend.dto.ProductDTO;
import com.example.hulk_store_backend.exception.OperationException;
import com.example.hulk_store_backend.exception.ResourceNotFoundException;
import com.example.hulk_store_backend.model.Product;
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
    public ProductDTO create(ProductDTO product) {
        try {
            Product savedProduct = productRepository.save(this.modelMapper.map(product, Product.class));
            return this.modelMapper.map(savedProduct, ProductDTO.class);
        }
        catch (Exception e) {
            throw new OperationException("Error creating : " + e.getMessage());
        }
    }

    @Override
    public Product update(Long id, Product product) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
