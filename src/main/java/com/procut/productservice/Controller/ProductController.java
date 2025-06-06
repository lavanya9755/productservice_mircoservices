package com.procut.productservice.Controller;

import com.procut.productservice.dto.ProductRequest;
import com.procut.productservice.dto.ProductResponse;
import com.procut.productservice.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        // try{
        //     Thread.sleep(5000);
        // }catch(InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
        return productService.getAllProducts();
    }
}