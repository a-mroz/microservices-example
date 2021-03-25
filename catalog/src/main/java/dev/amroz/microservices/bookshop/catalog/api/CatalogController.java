package dev.amroz.microservices.bookshop.catalog.api;

import javax.inject.Inject;
import dev.amroz.microservices.bookshop.catalog.service.ListBooksService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.reactivex.Flowable;

@Controller("/books")
class CatalogController {

    private final ListBooksService listBooksService;

    @Inject
    CatalogController(
        ListBooksService listBooksService) {
        this.listBooksService = listBooksService;
    }

    @ContinueSpan
    @Get
    @Produces(MediaType.APPLICATION_JSON_STREAM)
    Flowable<BookResponse> books() {
        return listBooksService.listBooks()
            .map(book -> new BookResponse(book.title(), book.price()));
    }
}
