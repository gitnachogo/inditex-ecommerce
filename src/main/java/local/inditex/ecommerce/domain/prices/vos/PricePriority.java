package local.inditex.ecommerce.domain.prices.vos;

import local.inditex.ecommerce.domain.shared.ValueObject;

public class PricePriority extends ValueObject<Integer> implements Comparable<PricePriority> {
    public PricePriority(final Integer value) {
        super(value);
    }

    @Override
    public int compareTo(PricePriority pricePriority) {
        return this.getValue().compareTo(pricePriority.getValue());
    }
}
