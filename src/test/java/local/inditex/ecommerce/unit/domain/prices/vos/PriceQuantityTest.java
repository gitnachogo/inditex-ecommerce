package local.inditex.ecommerce.unit.domain.prices.vos;

import local.inditex.ecommerce.domain.prices.vos.PriceQuantity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PriceQuantityTest {

    @Test
    void isNotValidCurrency() {
        final var badValue = BigDecimal.valueOf(0.00001d);
        assertThrows(IllegalArgumentException.class, () -> new PriceQuantity(badValue));
    }
}