package local.inditex.ecommerce.domain.prices;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PricePrimitives {

    private final Integer priceId;
    private final Integer brandId;
    private final Integer productId;
    private final BigDecimal quantity;
    private final String currency;
    private final Integer priority;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public PricePrimitives(
            Integer priceId,
            Integer brandId,
            Integer productId,
            BigDecimal quantity,
            String currency,
            Integer priority,
            LocalDateTime startDate,
            LocalDateTime endDate) {

        this.priceId = priceId;
        this.brandId = brandId;
        this.productId = productId;
        this.quantity = quantity;
        this.currency = currency;
        this.priority = priority;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getPriceId() {
        return priceId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Integer getProductId() {
        return productId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public Integer getPriority() {
        return priority;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}
