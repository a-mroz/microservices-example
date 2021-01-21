package dev.amroz.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import javax.inject.Inject;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@MicronautTest
class PricesApiTest {

    @Inject
    private EmbeddedServer embeddedServer;

    @BeforeEach
    public void setUp() {
        RestAssured.port = embeddedServer.getPort();
    }

    @Test
    void shouldRespondWithPrices() {
        given()
        .when()
            .get("/prices")
        .then()
            .statusCode(HttpStatus.OK.getCode())
            .assertThat().body("$.size()", is(2))
        ;
    }
}
