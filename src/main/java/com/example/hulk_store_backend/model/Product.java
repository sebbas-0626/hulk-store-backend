package com.example.hulk_store_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Long stock;
    @Column(name = "image_url")
    private String imageUrl;
    // Relación Muchos a Uno con Category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    private Boolean status;
}
