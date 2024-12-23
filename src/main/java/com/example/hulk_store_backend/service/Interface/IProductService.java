package com.example.hulk_store_backend.service.Interface;

import com.example.hulk_store_backend.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> all();
    Product findById(Long id);
    Product create(Product product);
    Product update(Long id, Product product);
    String delete(Long id);

}
