package com.procut.productservice.Models;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id //unique identifier for the product
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    
}
