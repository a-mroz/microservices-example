package dev.amroz.microservices.bookshop.recommendations.api;

import static org.assertj.core.api.Assertions.assertThat;
import javax.inject.Inject;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

@MicronautTest
public class RecommendationsApiTest {

    @Inject
    @Client("/")
    private HttpClient client;

    @Test
        // can debug on it and check if reflection in used or not - set a breakpoint in
        // RecommendationResponse.getTitle() - happens only if there is a public getter but
        // @Introspected seems to be unnecessary for that
    void shouldReturnRecommendations() {
        String recommendations = client.toBlocking().retrieve("/recommendations");
        System.out.println("recommendations = " + recommendations);
        assertThat(recommendations).isNotEmpty();
    }
}
