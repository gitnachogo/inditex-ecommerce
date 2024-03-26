package local.inditex.ecommerce.application.prices;

import local.inditex.ecommerce.domain.prices.*;
import org.springframework.stereotype.Service;

@Service
public class RetrieveActivePriceUseCaseImpl implements RetrieveActivePriceUseCase {

    private final PriceRepository priceRepository;
    private final ActivePriceService activePriceService;

    public RetrieveActivePriceUseCaseImpl(
            final PriceRepository priceRepository,
            final ActivePriceService activePriceService) {
        this.priceRepository = priceRepository;
        this.activePriceService = activePriceService;
    }
    @Override
    public Price handle(final RetrieveActivePriceQuery retrieveActivePriceQuery) {
        final var priceCollection = this.priceRepository.findAll();

        final var activePriceQuery = new ActivePriceQuery(
                retrieveActivePriceQuery.priceBrandId(),
                retrieveActivePriceQuery.priceProductId(),
                retrieveActivePriceQuery.priceStartDate(),
                priceCollection);
        return this.activePriceService.handle(activePriceQuery);
    }
}
