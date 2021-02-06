package dev.amroz.microservices.bookshop.recommendations.api;

import java.math.BigDecimal;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.reactivex.Flowable;

@Controller("/recommendations")
class CatalogController {

    @Get
    @Produces(MediaType.APPLICATION_JSON_STREAM)
    public void books() {

    }
}
