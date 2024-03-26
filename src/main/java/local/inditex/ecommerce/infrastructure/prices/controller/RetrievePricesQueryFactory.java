package local.inditex.ecommerce.infrastructure.prices.controller;

import local.inditex.ecommerce.domain.prices.RetrieveActivePriceQuery;
import local.inditex.ecommerce.domain.prices.vos.PriceBrandId;
import local.inditex.ecommerce.domain.prices.vos.PriceDateTime;
import local.inditex.ecommerce.domain.prices.vos.PriceProductId;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class RetrievePricesQueryFactory {

    private RetrievePricesQueryFactory() {}

    public static RetrieveActivePriceQuery create(
            final OffsetDateTime time,
            final Integer productId,
            final Integer brandId) {

        LocalDateTime localDateTime = time.toLocalDateTime();

        PriceDateTime priceStartDate = new PriceDateTime(localDateTime);
        PriceBrandId priceBrandId = new PriceBrandId(brandId);
        PriceProductId priceProductId = new PriceProductId(productId);

        return new RetrieveActivePriceQuery(priceStartDate, priceBrandId, priceProductId);
    }

}
