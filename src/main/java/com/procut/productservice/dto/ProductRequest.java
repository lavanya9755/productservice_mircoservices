package com.procut.productservice.dto;

import java.math.BigDecimal;


public record ProductRequest(String id, String name,String description, BigDecimal price) {
    // This record class is used to encapsulate the product request data
    // It includes fields for id, name, description, and price
    // The record automatically generates getters and a constructor
    // You can add validation annotations if needed, e.g., @NotBlank for name
} 