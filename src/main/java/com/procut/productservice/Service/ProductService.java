package com.procut.productservice.Service;

import org.springframework.stereotype.Service;
import java.util.*;
// import com.procut.productservice.Controller.List;
import com.procut.productservice.Models.Product;
import com.procut.productservice.Repo.ProductRepository;
import com.procut.productservice.dto.ProductRequest;
import com.procut.productservice.dto.ProductResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
    
                Product savedProduct = productRepository.save(product); //isko comment kar dena 
                // productRepository.save(product); // Save the product to the database(original )
                log.info("Product created successfully with ID: {}", savedProduct.getId());
               
                return new ProductResponse(
                    savedProduct.getId(),
                    savedProduct.getName(),
                    savedProduct.getDescription(),
                    savedProduct.getPrice()
                );
    
        // return new ProductResponse(
        //     product.getId(),
        //     product.getName(),
        //     product.getDescription(),
        //     product.getPrice()
        // );
    }
    

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
        .stream()
        .map(product -> new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice()))
        .toList();
    }
}
