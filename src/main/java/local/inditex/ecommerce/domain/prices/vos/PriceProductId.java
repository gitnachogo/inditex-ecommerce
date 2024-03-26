package local.inditex.ecommerce.domain.prices.vos;

import local.inditex.ecommerce.domain.shared.ValueObject;

public class PriceProductId extends ValueObject<Integer> {
    public PriceProductId(final Integer value) {
        super(value);
    }
}
