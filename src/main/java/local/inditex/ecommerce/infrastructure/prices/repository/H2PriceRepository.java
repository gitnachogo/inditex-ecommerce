package local.inditex.ecommerce.infrastructure.prices.repository;

import local.inditex.ecommerce.domain.prices.Price;
import local.inditex.ecommerce.domain.prices.PriceRepository;
import local.inditex.ecommerce.domain.prices.exceptions.PriceNotFoundException;
import local.inditex.ecommerce.domain.prices.vos.PriceBrandId;
import local.inditex.ecommerce.domain.prices.vos.PriceDateTime;
import local.inditex.ecommerce.domain.prices.vos.PriceId;
import local.inditex.ecommerce.domain.prices.vos.PriceProductId;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class H2PriceRepository implements PriceRepository {

    public static final String METHOD_NOT_IMPLEMENTED_YET = "Method not implemented yet";
    public static final String PRICE_NOT_FOUND_MESSAGE = "Price not found";
    private final JpaPriceDao jpaPriceDao;
    private final H2PriceDtoMapper h2PriceDtoMapper;

    public H2PriceRepository(
            final H2PriceDtoMapper h2PriceDtoMapper,
            final JpaPriceDao jpaPriceDao) {
        this.jpaPriceDao = jpaPriceDao;
        this.h2PriceDtoMapper = h2PriceDtoMapper;
    }

    @Override
    public Price findById(PriceId id) {
        throw new NotImplementedException(METHOD_NOT_IMPLEMENTED_YET);
    }

    @Override
    public List<Price> findAll() {
        throw new NotImplementedException(METHOD_NOT_IMPLEMENTED_YET);
    }

    @Override
    public void create(Price aggregateRoot) {
        throw new NotImplementedException(METHOD_NOT_IMPLEMENTED_YET);
    }

    @Override
    public void update(Price aggregateRoot) {
        throw new NotImplementedException(METHOD_NOT_IMPLEMENTED_YET);
    }

    @Override
    public void delete(Price aggregateRoot) {
        throw new NotImplementedException(METHOD_NOT_IMPLEMENTED_YET);
    }

    @Override
    public Price findActivePrice(PriceBrandId brandId, PriceProductId productId, PriceDateTime time) {
        final var priceDTO = this.jpaPriceDao.findActivePrice(
                brandId.getValue(),
                productId.getValue(),
                time.getValue()
        ).orElseThrow(() -> new PriceNotFoundException(PRICE_NOT_FOUND_MESSAGE));
        return this.h2PriceDtoMapper.toDomain(priceDTO);
    }
}
