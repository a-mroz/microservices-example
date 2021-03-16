package dev.amroz.microservices.bookshop.shop.api;

import javax.validation.Valid;
import dev.amroz.microservices.bookshop.shop.infrastructure.PurchaseNotifier;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.tracing.annotation.NewSpan;
import io.micronaut.validation.Validated;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller("/")
@Validated
class PurchasesController {

    private final PurchaseNotifier purchaseNotifier;

    @NewSpan
    @Post("/purchases")
    void purchase(@Valid PurchaseRequest request) {
        purchaseNotifier.notifyAboutPurchase(request.getTitle(), request.getQuantity());
    }
}
