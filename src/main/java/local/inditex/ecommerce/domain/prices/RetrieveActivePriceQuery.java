package local.inditex.ecommerce.domain.prices;

import local.inditex.ecommerce.domain.prices.vos.PriceBrandId;
import local.inditex.ecommerce.domain.prices.vos.PriceDateTime;
import local.inditex.ecommerce.domain.prices.vos.PriceProductId;

public record RetrieveActivePriceQuery(
        PriceDateTime priceStartDate,
        PriceBrandId priceBrandId,
        PriceProductId priceProductId
) {
}
