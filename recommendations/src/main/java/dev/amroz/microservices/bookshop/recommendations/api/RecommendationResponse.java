package dev.amroz.microservices.bookshop.recommendations.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class RecommendationResponse {

    @JsonProperty
    private final String title;
}
