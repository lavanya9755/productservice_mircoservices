package com.procut.productservice.Repo;

import org.springframework.data.mongodb.repository.*;

import com.procut.productservice.Models.Product;

public interface ProductRepository extends MongoRepository<Product,String>{
    
}
