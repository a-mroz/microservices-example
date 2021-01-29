package dev.amroz.microservices.bookshop.shop.shared;

import javax.inject.Singleton;
import io.micronaut.retry.event.RetryEvent;
import io.micronaut.retry.event.RetryEventListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
class RetryAttemptsLogger implements RetryEventListener {

    @Override
    public void onApplicationEvent(RetryEvent event) {
        log.warn("Retry attempt recorded: {}. Attempt: {} of {}", event,
            event.getRetryState().currentAttempt(), event.getRetryState().getMaxAttempts());
    }

    @Override
    public boolean supports(RetryEvent event) {
        return true;
    }
}
