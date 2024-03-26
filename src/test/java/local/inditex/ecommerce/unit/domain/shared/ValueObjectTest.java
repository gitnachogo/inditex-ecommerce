package local.inditex.ecommerce.unit.domain.shared;

import local.inditex.ecommerce.domain.prices.vos.PriceCurrency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValueObjectTest {

    @Test
    void isNotValidValueObject() {
        assertThrows(IllegalArgumentException.class, () -> new PriceCurrency(null));
    }

}