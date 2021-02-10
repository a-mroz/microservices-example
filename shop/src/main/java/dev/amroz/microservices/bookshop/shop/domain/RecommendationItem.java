package dev.amroz.microservices.bookshop.shop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class RecommendationItem {

    @JsonProperty
    private String title;

}
