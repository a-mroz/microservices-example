package dev.amroz.microservices.bookshop.catalog.api;

import java.math.BigDecimal;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.reactivex.Flowable;

@Controller("/books")
class CatalogController {

    @Get
    @Produces(MediaType.APPLICATION_JSON_STREAM)
    public Flowable<BookItem> books() {
        return Flowable.just(
            new BookItem("Moby Dick", BigDecimal.TEN),
            new BookItem("The Great Gatsby", BigDecimal.valueOf(15.5))
        );
    }
}
