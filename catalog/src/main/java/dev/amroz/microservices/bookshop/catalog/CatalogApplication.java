package dev.amroz.microservices.bookshop.catalog;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "${openapi.title}",
        version = "${api.version}",
        description = "${openapi.description}"
    )
)
public class CatalogApplication {

    public static void main(String[] args) {
        Micronaut.run(CatalogApplication.class, args);
    }
}
