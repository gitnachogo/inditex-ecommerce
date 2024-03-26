package local.inditex.ecommerce.domain.prices.vos;

import local.inditex.ecommerce.domain.shared.ValueObject;

public class PriceCurrency extends ValueObject<String> {
    public PriceCurrency(final String value) {
        super(value);
        this.ensureHasThreeCharacters(value);
    }

    private void ensureHasThreeCharacters(final String value) {
        if (value.length() != 3) {
            throw new IllegalArgumentException("Price currency length should be equals to 3");
        }
    }
}
