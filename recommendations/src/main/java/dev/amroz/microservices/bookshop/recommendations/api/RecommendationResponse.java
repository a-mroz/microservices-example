package dev.amroz.microservices.bookshop.recommendations.api;

import javax.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Schema(description = "Recommendations")
class RecommendationResponse {

    @Schema(required = true, description = "Book title", example = "Moby Dick")
    @NotBlank
    private final String title;

    // Schema is not generated if this is non-public or when there is no getter
    public String getTitle() {
        return title;
    }
}
