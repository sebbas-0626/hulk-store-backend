package com.example.hulk_store_backend.repository;

import com.example.hulk_store_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
