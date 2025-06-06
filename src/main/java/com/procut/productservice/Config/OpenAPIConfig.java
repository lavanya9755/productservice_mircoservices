package com.procut.productservice.Config;

// import org.eclipse.dirigible.components.openapi.domain.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
// import io.swagger.v3.oas.models.annotations.*;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {
    
    @Bean
    public OpenAPI productServiceAPI() {
        return new OpenAPI()
                    .info(new Info().title("Product Service")
                            .description("Rest APi documentation of Product Service")
                            .version("v0.0.1")
                            .license(new License().name("Aapache 2.0")))
            .externalDocs(new ExternalDocumentation()
            .description("Refer to do Product Service API")
            .url("https://prodcut-service-dummy-url.com/docs"));
    }
}
