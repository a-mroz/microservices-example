package dev.amroz.microservices.bookshop.shop.services;

import dev.amroz.microservices.bookshop.shop.domain.CatalogItem;
import io.reactivex.Flowable;

public interface CatalogService {
    Flowable<CatalogItem> getAvailableBooks();
}
