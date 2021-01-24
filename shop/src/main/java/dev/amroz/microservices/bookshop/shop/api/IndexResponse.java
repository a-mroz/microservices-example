package dev.amroz.microservices.bookshop.shop.api;

import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
class IndexResponse {

    @JsonProperty
    private final List<CatalogItem> availableBooks;

    @Builder
    static class CatalogItem {
        @JsonProperty
        private final String book;

        @JsonProperty
        private final BigDecimal price;
    }
}
