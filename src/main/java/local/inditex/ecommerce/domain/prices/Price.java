package local.inditex.ecommerce.domain.prices;

import local.inditex.ecommerce.domain.prices.vos.*;
import local.inditex.ecommerce.domain.shared.AggregateRoot;

import java.util.Objects;

public class Price extends AggregateRoot<PriceId> implements Comparable<Price> {
    private final PriceBrandId priceBrandId;
    private final PriceProductId priceProductId;
    private final PriceQuantity priceQuantity;
    private final PriceCurrency priceCurrency;
    private final PricePriority pricePriority;
    private final PriceDateTime priceStartDate;
    private final PriceDateTime priceEndDate;
    public Price(
            PriceId id,
            PriceBrandId priceBrandId,
            PriceProductId priceProductId,
            PriceQuantity priceQuantity,
            PriceCurrency priceCurrency,
            PricePriority pricePriority,
            PriceDateTime priceStartDate,
            PriceDateTime priceEndDate) {

        super(id);
        this.priceBrandId = priceBrandId;
        this.priceProductId = priceProductId;
        this.priceQuantity = priceQuantity;
        this.priceCurrency = priceCurrency;
        this.pricePriority = pricePriority;
        this.priceStartDate = priceStartDate;
        this.priceEndDate = priceEndDate;
    }

    public Boolean hasBrandId(final PriceBrandId priceBrandId) {
        return priceBrandId.equals(this.priceBrandId);
    }
    public Boolean hasProductId(final PriceProductId priceProductId) {
        return priceProductId.equals(this.priceProductId);
    }

    public Boolean inTime(final PriceDateTime currentDateTime) {
        return currentDateTime.isGreaterThanOrEqual(this.priceStartDate) &&
                currentDateTime.isLowerThanOrEqual(this.priceEndDate);
    }

    public PricePrimitives toPrimitives() {
        return new PricePrimitives(
                this.getId().getValue(),
                this.priceBrandId.getValue(),
                this.priceProductId.getValue(),
                this.priceQuantity.getValue(),
                this.priceCurrency.getValue(),
                this.pricePriority.getValue(),
                this.priceStartDate.getValue(),
                this.priceEndDate.getValue());
    }

    @Override
    public int compareTo(Price price) {
        return price.pricePriority.compareTo(this.pricePriority);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(priceBrandId, price.priceBrandId) && Objects.equals(priceProductId, price.priceProductId) && Objects.equals(priceQuantity, price.priceQuantity) && Objects.equals(priceCurrency, price.priceCurrency) && Objects.equals(pricePriority, price.pricePriority) && Objects.equals(priceStartDate, price.priceStartDate) && Objects.equals(priceEndDate, price.priceEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceBrandId, priceProductId, priceQuantity, priceCurrency, pricePriority, priceStartDate, priceEndDate);
    }
}
