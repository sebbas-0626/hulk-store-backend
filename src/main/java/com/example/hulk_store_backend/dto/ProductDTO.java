package com.example.hulk_store_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class ProductDTO {
    private Long id;

    @JsonProperty("product_name")
    private String name;

    @JsonProperty("product_description")
    private String description;

    @JsonProperty("product_price")
    private Double price;

    @JsonProperty("product_stock")
    private Long stock;

    @JsonProperty("product_image_url")
    private String imageUrl;

    @JsonProperty("product_status")
    private Boolean status;
}
