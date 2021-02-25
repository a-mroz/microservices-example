package dev.amroz.microservices.bookshop.recommendations.api;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

@Introspected
@RequiredArgsConstructor
@Schema(description = "Recommendations")
class RecommendationResponse {

    @Schema(required = true, description = "Book title", example = "Moby Dick")
    @JsonProperty
    @NotBlank
    private final String title;

    // Schema is not generated if this is non-public or when there is no getter
    public String getTitle() {
        return title;
    }
}
