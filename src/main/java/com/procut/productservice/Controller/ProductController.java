package com.procut.productservice.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.procut.productservice.Models.Product;
import com.procut.productservice.Service.ProductService;
import com.procut.productservice.dto.ProductRequest;

@RequestMapping("/api/product")
@RestController
public class ProductController {

    private ProductService productService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201 created
    public  Product createProduct(@RequestBody ProductRequest productRequest ){
        return productService.createProduct(productRequest);   
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK) //200 ok
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
