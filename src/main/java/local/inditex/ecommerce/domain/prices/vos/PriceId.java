package local.inditex.ecommerce.domain.prices.vos;

import local.inditex.ecommerce.domain.shared.ValueObject;

public class PriceId extends ValueObject<Integer> {
    public PriceId(final Integer value) {
        super(value);
    }
}
