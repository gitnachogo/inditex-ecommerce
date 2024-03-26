package local.inditex.ecommerce.domain.prices.exceptions;

public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(final String message) {
        super(message);
    }
}
