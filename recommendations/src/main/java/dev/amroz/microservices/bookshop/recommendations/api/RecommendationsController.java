package dev.amroz.microservices.bookshop.recommendations.api;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.reactivex.Flowable;

@Controller("/recommendations")
class RecommendationsController {

    @Get
    @Produces(MediaType.APPLICATION_JSON_STREAM)
    Flowable<RecommendationResponse> recommendations() {
        return Flowable.just(
            new RecommendationResponse("Atomic Habits"),
            new RecommendationResponse("Domain Driven Design")
        );
    }
}
