package dev.amroz.api;

import java.math.BigDecimal;
import java.util.Map;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/prices")
class PricesController {

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, BigDecimal> prices() {
        return Map.of(
            "Moby Dick", BigDecimal.TEN,
            "The Great Gatsby", BigDecimal.valueOf(15.5)
        );
    }
}
