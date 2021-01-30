package dev.amroz.microservices.bookshop.catalog;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "Catalog Application",
        version = "0.0.1",
        description = "Microservice responsible for serving catalog data."
    )
)
public class CatalogApplication {

    public static void main(String[] args) {
        Micronaut.run(CatalogApplication.class, args);
    }
}
