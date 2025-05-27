package com.procut.productservice.Service;

import org.springframework.stereotype.Service;
import java.util.*;
// import com.procut.productservice.Controller.List;
import com.procut.productservice.Models.Product;
import com.procut.productservice.Repo.ProductRepository;
import com.procut.productservice.dto.ProductRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private ProductRepository productRepository;

    public Product createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name()) //dont use gtter setter
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("priduct created sucessfully ");

        return product;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
