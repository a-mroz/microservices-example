package dev.amroz.microservices.bookshop.shop.infrastructure;

import dev.amroz.microservices.bookshop.shop.domain.CatalogItem;
import dev.amroz.microservices.bookshop.shop.services.CatalogService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;
import io.reactivex.Flowable;

@Client("http://localhost:8081")
public interface CatalogClient extends CatalogService {

    @Retryable(
        attempts = "${catalog.books.retry.attempts:3}",
        multiplier = "${catalog.books.retry.multiplier:1}",
        delay = "${catalog.books.retry.delay:1s}")
    @Override
    @Get("/books")
    @Consumes(MediaType.APPLICATION_JSON_STREAM)
    Flowable<CatalogItem> getAvailableBooks();
}
