package dev.amroz.microservices.bookshop.shop.infrastructure;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface PurchaseNotifier {

    @Topic("purchases")
    void notifyAboutPurchase(@KafkaKey String title,
                             int quantity); //return Publisher for non-blocking
}
