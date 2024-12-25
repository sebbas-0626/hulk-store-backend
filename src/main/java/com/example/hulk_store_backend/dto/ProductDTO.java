package com.example.hulk_store_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {
    private Long id;
    @JsonProperty("product_name")
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String imageUrl;
    private Boolean status;
}
