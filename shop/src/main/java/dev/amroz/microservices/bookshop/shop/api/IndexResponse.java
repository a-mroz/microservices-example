package dev.amroz.microservices.bookshop.shop.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
class IndexResponse {

    @Schema(description = "Available books")
    @NotNull
    private final List<CatalogItem> availableBooks;

    @Schema(description = "Recommended books")
    @NotNull
    private final List<RecommendationItem> recommendations;

    public List<CatalogItem> getAvailableBooks() {
        return availableBooks;
    }

    public List<RecommendationItem> getRecommendations() {
        return recommendations;
    }

    @Builder
    static class CatalogItem {

        @Schema(description = "Book title", example = "Atomic Habits")
        @NotBlank
        private final String book;

        @NotNull
        @Schema(description = "Book price", example = "10.4")
        private final BigDecimal price;

        public String getBook() {
            return book;
        }

        public BigDecimal getPrice() {
            return price;
        }
    }

    @Builder
    static class RecommendationItem {

        @NotBlank
        @Schema(description = "Title of a recommended book", example = "Clean Code")
        private final String title;

        public String getTitle() {
            return title;
        }
    }


}
