package dev.amroz.microservices.bookshop.catalog.api;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class BookItem {

    @JsonProperty
    private final String book;

    @JsonProperty
    private final BigDecimal price;
}
