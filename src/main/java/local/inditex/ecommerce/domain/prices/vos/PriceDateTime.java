package local.inditex.ecommerce.domain.prices.vos;

import local.inditex.ecommerce.domain.shared.ValueObject;

import java.time.LocalDateTime;

public class PriceDateTime extends ValueObject<LocalDateTime> {
    public PriceDateTime(final LocalDateTime value) {
        super(value);
    }

    public Boolean isGreaterThanOrEqual(final PriceDateTime priceDateTime) {
        return !this.getValue().isBefore(priceDateTime.getValue());
    }
    public Boolean isLowerThanOrEqual(final PriceDateTime priceDateTime) {
        return !this.getValue().isAfter(priceDateTime.getValue());
    }
}
