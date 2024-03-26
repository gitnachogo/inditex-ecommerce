package local.inditex.ecommerce.infrastructure.prices.controller;

import local.inditex.ecommerce.domain.prices.RetrieveActivePriceUseCase;
import local.inditex.ecommerce.domain.prices.exceptions.PriceNotFoundException;
import org.openapitools.api.PricesApi;
import org.openapitools.model.ActivePriceResponse;
import org.openapitools.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
public class PricesController implements PricesApi {

    private final RetrieveActivePriceUseCase retrieveActivePriceUseCase;
    private final ControllerPricePrimitivesMapper controllerPricePrimitivesMapper;

    public PricesController(
            final RetrieveActivePriceUseCase retrieveActivePriceUseCase,
            final ControllerPricePrimitivesMapper controllerPricePrimitivesMapper) {

        this.retrieveActivePriceUseCase = retrieveActivePriceUseCase;
        this.controllerPricePrimitivesMapper = controllerPricePrimitivesMapper;
    }

    @Override
    public ResponseEntity<ActivePriceResponse> getActivePrice(
            final OffsetDateTime time,
            final Integer productId,
            final Integer brandId) {

        final var query = RetrievePricesQueryFactory.create(time, productId, brandId);

        final var pricePrimitive = this.retrieveActivePriceUseCase.handle(query).toPrimitives();

        return ResponseEntity.ok(this.controllerPricePrimitivesMapper.fromDomain(pricePrimitive));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(new ErrorResponse().message(ex.getMessage()).status(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(PriceNotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse().message(ex.getMessage()).status(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllOtherExceptions(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse().message(ex.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
