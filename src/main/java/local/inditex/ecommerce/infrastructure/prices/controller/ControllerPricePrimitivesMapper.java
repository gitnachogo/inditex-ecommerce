package local.inditex.ecommerce.infrastructure.prices.controller;

import local.inditex.ecommerce.domain.prices.PricePrimitives;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.openapitools.model.ActivePriceResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring")
public interface ControllerPricePrimitivesMapper {

    @Mapping(source = "quantity", target = "quantity", qualifiedByName = "bigDecimalToFloat")
    @Mapping(source = "startDate", target = "startDate", qualifiedByName = "localDateTimeToOffsetDateTime")
    @Mapping(source = "endDate", target = "endDate", qualifiedByName = "localDateTimeToOffsetDateTime")
    ActivePriceResponse fromDomain(final PricePrimitives price);

    @Named("bigDecimalToFloat")
    default Float bigDecimalToFloat(BigDecimal value) {
        return value == null ? null : value.floatValue();
    }

    @Named("localDateTimeToOffsetDateTime")
    default OffsetDateTime localDateTimeToOffsetDateTime(LocalDateTime value) {
        return value == null ? null : value.atOffset(ZoneOffset.UTC);
    }
}
