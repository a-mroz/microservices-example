package dev.amroz.microservices.bookshop.shop.api;

import javax.inject.Inject;
import java.util.List;
import dev.amroz.microservices.bookshop.shop.services.CatalogService;
import dev.amroz.microservices.bookshop.shop.services.RecommendationsService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

@Controller("/")
class IndexController {


    private final CatalogService catalogService;
    private final RecommendationsService recommendationsService;

    /*
    TODO: It can't be replaced with @RequiredArgsConstructor when "io.freefair.lombok" plugin is
     used: https://github.com/micronaut-projects/micronaut-core/issues/218 possible solution
     would be to delombok, or add the dependencies manually, skipping the plugin
    */
    @Inject
    IndexController(CatalogService catalogService,
                    RecommendationsService recommendationsService) {
        this.catalogService = catalogService;
        this.recommendationsService = recommendationsService;
    }

    @Get
    IndexResponse index() {
        Single<List<IndexResponse.CatalogItem>> availableBooks = fetchAvailableBooks();
        Single<List<IndexResponse.RecommendationItem>> recommendations = fetchRecommendations();

        return IndexResponse.builder()
            .availableBooks(availableBooks.blockingGet())
            .recommendations(recommendations.blockingGet())
            .build();
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
