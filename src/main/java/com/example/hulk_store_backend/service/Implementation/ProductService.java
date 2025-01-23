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
        return  null;
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
