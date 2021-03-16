package dev.amroz.microservices.bookshop.shop.api;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import io.micronaut.core.annotation.Introspected;

@Introspected
class PurchaseRequest {

    @NotBlank
    private String title;

    @NotNull
    @Min(1)
    private Integer quantity;

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    int getQuantity() {
        return quantity;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
