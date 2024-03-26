package local.inditex.ecommerce.domain.prices;

public interface RetrieveActivePriceUseCase {
    Price handle(final RetrieveActivePriceQuery retrieveActivePriceQuery);
}
