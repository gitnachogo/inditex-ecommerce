package local.inditex.ecommerce.unit.domain.prices;

import local.inditex.ecommerce.domain.prices.ActivePriceQuery;
import local.inditex.ecommerce.domain.prices.ActivePriceService;
import local.inditex.ecommerce.domain.prices.Price;
import local.inditex.ecommerce.domain.prices.vos.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActivePriceServiceTest {
    private final ActivePriceService activePriceService;

    public ActivePriceServiceTest() {
        this.activePriceService = new ActivePriceService();
    }

    @Test
    void handle_filters() {
        final var expectedResult = new Price(
                new PriceId(1),
                new PriceBrandId(0),
                new PriceProductId(0),
                new PriceQuantity(BigDecimal.ONE),
                new PriceCurrency("EUR"),
                new PricePriority(1),
                new PriceDateTime(LocalDateTime.now().plusDays(-1000)),
                new PriceDateTime(LocalDateTime.now().plusDays(1000)));

        final var query = provideCurrentPriceServiceForFiltersTest(expectedResult);

        assertEquals(this.activePriceService.handle(query),expectedResult);
    }

    @Test
    void handle_sort() {
        final var expectedResult = new Price(
                new PriceId(1),
                new PriceBrandId(0),
                new PriceProductId(0),
                new PriceQuantity(BigDecimal.ONE),
                new PriceCurrency("EUR"),
                new PricePriority(2),
                new PriceDateTime(LocalDateTime.now().plusDays(-1000)),
                new PriceDateTime(LocalDateTime.now().plusDays(1000)));

        final var query = provideCurrentPriceServiceForSortTest(expectedResult);

        assertEquals(this.activePriceService.handle(query),expectedResult);
    }

    private static ActivePriceQuery provideCurrentPriceServiceForFiltersTest(Price expectedResult) {
        return new ActivePriceQuery(
                new PriceBrandId(0),
                new PriceProductId(0),
                new PriceDateTime(LocalDateTime.now()),
                List.of(
                        expectedResult,
                        new Price(
                                new PriceId(2),
                                new PriceBrandId(1),
                                new PriceProductId(0),
                                new PriceQuantity(BigDecimal.ONE),
                                new PriceCurrency("EUR"),
                                new PricePriority(1),
                                new PriceDateTime(LocalDateTime.now().plusDays(-1000)),
                                new PriceDateTime(LocalDateTime.now().plusDays(1000))
                        ),
                        new Price(
                                new PriceId(3),
                                new PriceBrandId(0),
                                new PriceProductId(1),
                                new PriceQuantity(BigDecimal.ONE),
                                new PriceCurrency("EUR"),
                                new PricePriority(1),
                                new PriceDateTime(LocalDateTime.now().plusDays(-1000)),
                                new PriceDateTime(LocalDateTime.now().plusDays(1000))
                        ),
                        new Price(
                                new PriceId(4),
                                new PriceBrandId(0),
                                new PriceProductId(0),
                                new PriceQuantity(BigDecimal.ONE),
                                new PriceCurrency("EUR"),
                                new PricePriority(1),
                                new PriceDateTime(LocalDateTime.now().plusDays(-1000)),
                                new PriceDateTime(LocalDateTime.now().plusDays(-999))
                        )
                ));
    }

    private static ActivePriceQuery provideCurrentPriceServiceForSortTest(Price expectedResult) {
        return new ActivePriceQuery(
                new PriceBrandId(0),
                new PriceProductId(0),
                new PriceDateTime(LocalDateTime.now()),
                List.of(
                        new Price(
                                new PriceId(2),
                                new PriceBrandId(0),
                                new PriceProductId(0),
                                new PriceQuantity(BigDecimal.ONE),
                                new PriceCurrency("EUR"),
                                new PricePriority(0),
                                new PriceDateTime(LocalDateTime.now().plusDays(-1000)),
                                new PriceDateTime(LocalDateTime.now().plusDays(1000))
                        ),
                        new Price(
                                new PriceId(3),
                                new PriceBrandId(0),
                                new PriceProductId(0),
                                new PriceQuantity(BigDecimal.ONE),
                                new PriceCurrency("EUR"),
                                new PricePriority(1),
                                new PriceDateTime(LocalDateTime.now().plusDays(-1000)),
                                new PriceDateTime(LocalDateTime.now().plusDays(1000))
                        ),
                        expectedResult
                ));
    }

}