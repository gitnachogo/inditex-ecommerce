package local.inditex.ecommerce.domain.prices;

import local.inditex.ecommerce.domain.prices.vos.PriceBrandId;
import local.inditex.ecommerce.domain.prices.vos.PriceDateTime;
import local.inditex.ecommerce.domain.prices.vos.PriceId;
import local.inditex.ecommerce.domain.prices.vos.PriceProductId;
import local.inditex.ecommerce.domain.shared.Repository;

public interface PriceRepository extends Repository<Price, PriceId> {

    Price findActivePrice(
            final PriceBrandId brandId,
            final PriceProductId productId,
            final PriceDateTime time);
}
