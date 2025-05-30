package com.procut.productservice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import com.mongodb.assertions.Assertions;
import com.procut.productservice.Models.Product;
import com.procut.productservice.Repo.ProductRepository;

import io.restassured.RestAssured;

import java.math.BigDecimal;

import org.hamcrest.Matchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class ProductserviceApplicationTests {

    @Container
    @ServiceConnection //automatic monodb uri fromspring
    static MongoDBContainer mongoDBContainer = 
        new MongoDBContainer(DockerImageName.parse("mongo:7.0.5"));

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testMongoConnection() {
        Product product = new Product(null, "Test", "Test Desc", new BigDecimal("1000"));
        Product saved = productRepository.save(product);
        Assertions.assertNotNull(saved.getId());
    }
    @Test
    void shouldCreateProduct() {
        String requestBody = """
            {
                
                "name": "iPhone 15",
                "description": "iPhone 15 is a smartphone from Apple",
                "price": 1000
            }
            """;

        RestAssured.given()
            .contentType("application/json")
            .body(requestBody)
            .when()
            .post("/api/product")
            .then()
            .log().body()
            .body("id", Matchers.notNullValue())
            .body("name", Matchers.equalTo("iPhone 15"))
            .body("description", Matchers.equalTo("iPhone 15 is a smartphone from Apple"))
            .body("price", Matchers.equalTo(1000));
    }
}
