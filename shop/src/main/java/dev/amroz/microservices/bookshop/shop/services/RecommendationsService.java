package dev.amroz.microservices.bookshop.shop.services;

import dev.amroz.microservices.bookshop.shop.domain.RecommendationItem;
import io.reactivex.Flowable;

public interface RecommendationsService {

    Flowable<RecommendationItem> getRecommendations();
}
