package com.example.hulk_store_backend.service.Implementation;


import com.example.hulk_store_backend.dto.ProductDTO;
import com.example.hulk_store_backend.model.Product;
import com.example.hulk_store_backend.repository.ProductRepository;
import com.example.hulk_store_backend.service.Interface.IProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ProductService implements IProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> all() {
        return this.productRepository.findAll().stream().map(product -> this.modelMapper
                        .map(product, ProductDTO.class)).toList();
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public Product update(Long id, Product product) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return "";
    }

}
