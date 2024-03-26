package local.inditex.ecommerce.infrastructure.prices.repository;

import local.inditex.ecommerce.domain.prices.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface H2PriceDtoMapper {

    @Mapping(target = "id", expression = "java(new PriceId(priceDto.getId()))")
    @Mapping(target = "priceBrandId", expression = "java(new PriceBrandId(priceDto.getBrandId()))")
    @Mapping(target = "priceProductId", expression = "java(new PriceProductId(priceDto.getProductId()))")
    @Mapping(target = "priceQuantity", expression = "java(new PriceQuantity(priceDto.getPrice()))")
    @Mapping(target = "priceCurrency", expression = "java(new PriceCurrency(priceDto.getCurrency()))")
    @Mapping(target = "pricePriority", expression = "java(new PricePriority(priceDto.getPriority()))")
    @Mapping(target = "priceStartDate", expression = "java(new PriceDateTime(priceDto.getStartDate()))")
    @Mapping(target = "priceEndDate", expression = "java(new PriceDateTime(priceDto.getEndDate()))")
    Price toDomain(final PriceDto priceDto);
}
