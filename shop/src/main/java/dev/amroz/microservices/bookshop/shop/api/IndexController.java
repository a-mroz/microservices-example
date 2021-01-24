package dev.amroz.microservices.bookshop.shop.api;

import java.util.List;
import dev.amroz.microservices.bookshop.shop.services.CatalogService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

@Controller("/")
class IndexController {

    private final CatalogService catalogService;

    IndexController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Get
    IndexResponse index() {
        Single<List<IndexResponse.CatalogItem>> availableBooks = catalogService.getAvailableBooks()
            .map(item -> IndexResponse.CatalogItem.builder()
                .book(item.title())
                .price(item.price())
                .build())
            .toList();

        return IndexResponse.builder()
            .availableBooks(availableBooks.blockingGet())
            .build();
    }

}
