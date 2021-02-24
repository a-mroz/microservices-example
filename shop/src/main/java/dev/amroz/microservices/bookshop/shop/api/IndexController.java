package dev.amroz.microservices.bookshop.shop.api;

import java.util.List;
import dev.amroz.microservices.bookshop.shop.services.CatalogService;
import dev.amroz.microservices.bookshop.shop.services.RecommendationsService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.tracing.annotation.NewSpan;
import io.reactivex.Single;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller("/")
class IndexController {

    private final CatalogService catalogService;
    private final RecommendationsService recommendationsService;

    @NewSpan("index")
    @Get
    Single<IndexResponse> index() {
        return fetchAvailableBooks()
            .zipWith(fetchRecommendations(), IndexResponse::new);
    }

    private Single<List<IndexResponse.CatalogItem>> fetchAvailableBooks() {
        return catalogService.getAvailableBooks()
            .map(item -> IndexResponse.CatalogItem.builder()
                .book(item.title())
                .price(item.price())
                .build())
            .toList();
    }

    private Single<List<IndexResponse.RecommendationItem>> fetchRecommendations() {
        return recommendationsService.getRecommendations().map(
            item -> IndexResponse.RecommendationItem.builder()
                .title(item.title())
                .build()
        ).toList();
    }

}
