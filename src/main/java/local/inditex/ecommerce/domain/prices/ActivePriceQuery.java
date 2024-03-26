package local.inditex.ecommerce.domain.prices;

import local.inditex.ecommerce.domain.prices.vos.PriceBrandId;
import local.inditex.ecommerce.domain.prices.vos.PriceDateTime;
import local.inditex.ecommerce.domain.prices.vos.PriceProductId;

import java.util.List;

public record ActivePriceQuery(
        PriceBrandId brandId,
        PriceProductId productId,
        PriceDateTime priceStartDate,
        List<Price> priceCollection
) {
}
