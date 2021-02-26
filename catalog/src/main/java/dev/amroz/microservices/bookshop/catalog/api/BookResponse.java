package dev.amroz.microservices.bookshop.catalog.api;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class BookResponse {

    @Schema(description = "Book title", example = "Moby Dick")
    @NotNull
    private final String book;

    @NotNull
    @Schema(description = "Price of the book", example = "12.25")
    private final BigDecimal price;

    public String getBook() {
        return book;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
