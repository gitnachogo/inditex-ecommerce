package local.inditex.ecommerce.unit.domain.prices.vos;

import local.inditex.ecommerce.domain.prices.vos.PriceCurrency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PriceCurrencyTest {

    @Test
    void isNotValidCurrency() {
        assertThrows(IllegalArgumentException.class, () -> new PriceCurrency("EURO"));
    }
}