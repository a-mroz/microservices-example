package dev.amroz.microservices.bookshop.catalog.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import javax.inject.Inject;
import io.micronaut.http.HttpStatus;
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
