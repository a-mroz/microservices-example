package dev.amroz.api;

import java.math.BigDecimal;
import java.util.List;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/prices")
class PricesController {

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookPrice> prices() {
        return List.of(
            new BookPrice("Moby Dick", BigDecimal.TEN),
            new BookPrice("The Great Gatsby", BigDecimal.valueOf(15.5))
        );
    }
}
