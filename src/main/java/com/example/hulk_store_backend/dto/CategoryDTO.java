package com.example.hulk_store_backend.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    private Long id;

    @JsonProperty("category_name")
    private String name;

    @JsonProperty("category_description")
    private String description;
}

