package dev.amroz.microservices.bookshop.shop.domain;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class CatalogItem {

    @JsonProperty
    private String title;

    @JsonProperty
    private BigDecimal price;


}
