package local.inditex.ecommerce.domain.prices.vos;

import local.inditex.ecommerce.domain.shared.ValueObject;

import java.math.BigDecimal;

public class PriceQuantity extends ValueObject<BigDecimal> {
    public static final String TWO_DECIMALS_OR_LESS_MESSAGE = "Price quantity should have two decimals or less";

    public PriceQuantity(final BigDecimal value) {
        super(value);
        this.ensureHasTwoDecimalsOrLess(value);
    }

    private void ensureHasTwoDecimalsOrLess(final BigDecimal value) {
        if (value.scale() > 2) {
            throw new IllegalArgumentException(TWO_DECIMALS_OR_LESS_MESSAGE);
        }
    }
}
