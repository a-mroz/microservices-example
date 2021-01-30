package dev.amroz.microservices.bookshop.shop;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@OpenAPIDefinition(
    info = @Info(
        title = "Shop Application",
        version = "0.0.1",
        description = "Toy application for playing with Microservices"
    )
)
public class ShopApplication {

    public static void main(String[] args) {
        Micronaut.run(ShopApplication.class, args);
    }
}
