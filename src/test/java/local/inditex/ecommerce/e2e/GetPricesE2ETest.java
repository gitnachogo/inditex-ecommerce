package local.inditex.ecommerce.e2e;

import local.inditex.ecommerce.infrastructure.shared.EcommerceApplication;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static io.restassured.RestAssured.when;

@SpringBootTest(classes = EcommerceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("local")
class GetPricesE2ETest {

    private static final String URL = "http://localhost:8080/api/v1/prices/active";
    private static final String PRODUCT_ID_S = "productId=%s";
    private static final String BRAND_ID_S = "brandId=%s";
    private static final String TIME_S = "time=%s";
    private static final String URL_WITH_PARAMETERS_TEMPLATE = "%s?%s&%s&%s";

    @ParameterizedTest
    @MethodSource("priceFoundProvider")
    void pricesFound(
            final String productId,
            final String brandId,
            final String time,
            final String expectedPriceQuantity) {

        final var productIdParam = String.format(PRODUCT_ID_S, productId);
        final var brandIdParam = String.format(BRAND_ID_S, brandId);
        final var timeParam = String.format(TIME_S, time);

        final var urlWithParams = String.format(URL_WITH_PARAMETERS_TEMPLATE, URL, productIdParam, brandIdParam, timeParam);

        when()
                .get(urlWithParams)
                .then()
                .statusCode(200)
                .body(Matchers.containsString(expectedPriceQuantity));
    }

    @Test
    void pricesNotFound() {

        final var productIdParam = String.format(PRODUCT_ID_S, "0");
        final var brandIdParam = String.format(BRAND_ID_S, "0");
        final var timeParam = String.format(TIME_S, "2020-06-14T10:00:00Z");

        final var urlWithParams = String.format(URL_WITH_PARAMETERS_TEMPLATE, URL, productIdParam, brandIdParam, timeParam);

        when()
                .get(urlWithParams)
                .then()
                .statusCode(404);
    }

    @Test
    void pricesInternalServerError() {

        final var productIdParam = String.format(PRODUCT_ID_S, "abc");
        final var brandIdParam = String.format(BRAND_ID_S, "0");
        final var timeParam = String.format(TIME_S, LocalDateTime.now());

        final var urlWithParams = String.format(URL_WITH_PARAMETERS_TEMPLATE, URL, productIdParam, brandIdParam, timeParam);

        when()
                .get(urlWithParams)
                .then()
                .statusCode(500);
    }

    private static Stream<Arguments> priceFoundProvider() {
        return Stream.of(
                Arguments.of("35455", "1", "2020-06-14T10:00:00Z", "35.5"),
                Arguments.of("35455", "1", "2020-06-14T16:00:00Z", "25.45"),
                Arguments.of("35455", "1", "2020-06-14T21:00:00Z", "35.5"),
                Arguments.of("35455", "1", "2020-06-15T10:00:00Z", "30.5"),
                Arguments.of("35455", "1", "2020-06-16T21:00:00Z", "38.95"));
    }

}

