package local.inditex.ecommerce.domain.prices;

import local.inditex.ecommerce.domain.prices.exceptions.PriceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ActivePriceService {

    private static final String PRICE_NOT_FOUND = "Price not found";

    public Price handle(final ActivePriceQuery activePriceQuery) {
        return activePriceQuery.priceCollection().stream()
                .filter(priceElement ->
                        priceElement.inTime(activePriceQuery.priceStartDate()) &&
                        priceElement.hasBrandId(activePriceQuery.brandId()) &&
                        priceElement.hasProductId(activePriceQuery.productId())
                )
                .sorted()
                .findFirst()
                .orElseThrow(() -> new PriceNotFoundException(PRICE_NOT_FOUND));
    }

}
