package dev.amroz.microservices.bookshop.shop.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Introspected
@Builder
class IndexResponse {

    @JsonProperty
    @Schema(description = "Available books")
    @NotNull
    private final List<CatalogItem> availableBooks;

    @JsonProperty
    @Schema(description = "Recommended books")
    @NotNull
    private final List<RecommendationItem> recommendations;

    public List<CatalogItem> getAvailableBooks() {
        return availableBooks;
    }

    public List<RecommendationItem> getRecommendations() {
        return recommendations;
    }

    @Introspected
    @Builder
    static class CatalogItem {

        @Schema(description = "Book title", example = "Atomic Habits")
        @NotBlank
        @JsonProperty
        private final String book;

        @NotNull
        @JsonProperty
        @Schema(description = "Book price", example = "10.4")
        private final BigDecimal price;

        public String getBook() {
            return book;
        }

        public BigDecimal getPrice() {
            return price;
        }
    }

    @Introspected
    @Builder
    static class RecommendationItem {

        @JsonProperty
        @NotBlank
        @Schema(description = "Title of a recommended book", example = "Clean Code")
        private final String title;

        public String getTitle() {
            return title;
        }
    }


}
