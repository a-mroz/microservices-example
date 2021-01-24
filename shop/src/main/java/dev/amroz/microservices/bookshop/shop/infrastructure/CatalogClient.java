package dev.amroz.microservices.bookshop.shop.infrastructure;

import dev.amroz.microservices.bookshop.shop.domain.CatalogItem;
import dev.amroz.microservices.bookshop.shop.services.CatalogService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

@Client("http://localhost:8081")
public interface CatalogClient extends CatalogService {

    @Override
    @Get("/books")
    @Consumes(MediaType.APPLICATION_JSON_STREAM)
    Flowable<CatalogItem> getAvailableBooks();
}
