package local.inditex.ecommerce.application.prices;

import local.inditex.ecommerce.domain.prices.*;
import org.springframework.stereotype.Service;

@Service
public class RetrieveActivePriceUseCaseImpl implements RetrieveActivePriceUseCase {

    private final PriceRepository priceRepository;

    public RetrieveActivePriceUseCaseImpl(
            final PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
    @Override
    public Price handle(final RetrieveActivePriceQuery retrieveActivePriceQuery) {
        return this.priceRepository.findActivePrice(
                retrieveActivePriceQuery.priceBrandId(),
                retrieveActivePriceQuery.priceProductId(),
                retrieveActivePriceQuery.priceStartDate());
    }
}
