package com.procut.productservice.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    
    @Id
    private String id;  // MongoDB will auto-generate this
    
    private String name;
    private String description;
    private BigDecimal price;
}
