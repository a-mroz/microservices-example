package dev.amroz.microservices.bookshop.shop.infrastructure;

import dev.amroz.microservices.bookshop.shop.domain.RecommendationItem;
import dev.amroz.microservices.bookshop.shop.services.RecommendationsService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;
import io.reactivex.Flowable;

@Client("http://localhost:8082")
public interface RecommendationsClient extends RecommendationsService {

    @Override
    @Get("/recommendations")
    @Consumes(MediaType.APPLICATION_JSON_STREAM)
    // TODO check why it's not included by default
    @CircuitBreaker(/*includes = {io.micronaut.http.client.exceptions.HttpClientException.class}*/)
    Flowable<RecommendationItem> getRecommendations();
}
