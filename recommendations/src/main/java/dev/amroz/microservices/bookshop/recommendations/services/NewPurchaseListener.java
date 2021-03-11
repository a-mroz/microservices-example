package dev.amroz.microservices.bookshop.recommendations.services;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class NewPurchaseListener {

    @Topic("purchases")
    public void receive(@KafkaKey String book) {
        System.out.println("New purchase for recommendations " + book);
    }
}
