package dev.amroz.microservices.bookshop.catalog.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class BooksResponse {

    @JsonProperty
    private final List<BookItem> books;
}
