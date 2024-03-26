package local.inditex.ecommerce.unit.domain.prices.vos;

import local.inditex.ecommerce.domain.prices.vos.PriceDateTime;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PriceDateTimeTest {

    @Test
    void isGreaterThanOrEqual_equals() {
        final PriceDateTime first = new PriceDateTime(LocalDateTime.now());

        assertTrue(first.isGreaterThanOrEqual(first));
    }
    @Test
    void isGreaterThanOrEqual_greater() {
        final PriceDateTime first = new PriceDateTime(LocalDateTime.now().plusDays(1000));
        final PriceDateTime second = new PriceDateTime(LocalDateTime.now());

        assertTrue(first.isGreaterThanOrEqual(second));
    }
    @Test
    void isLowerThanOrEqual_equals() {
        final PriceDateTime first = new PriceDateTime(LocalDateTime.now());

        assertTrue(first.isLowerThanOrEqual(first));
    }
    @Test
    void isLowerThanOrEqual_lower() {
        final PriceDateTime first = new PriceDateTime(LocalDateTime.now().plusDays(-1000));
        final PriceDateTime second = new PriceDateTime(LocalDateTime.now());

        assertTrue(first.isLowerThanOrEqual(second));
    }
}