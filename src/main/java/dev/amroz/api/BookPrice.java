package dev.amroz.api;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
class BookPrice {

    @JsonProperty
    private final String book;

    @JsonProperty
    private final BigDecimal price;
}
