package local.inditex.ecommerce.infrastructure.prices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface JpaPriceDao extends JpaRepository<PriceDto, Integer> {
    @Query("SELECT p FROM PriceDto p WHERE (:priceStartDate BETWEEN p.startDate AND p.endDate) AND p.brandId = :brandId AND p.productId = :productId ORDER BY p.priority DESC LIMIT 1")
    Optional<PriceDto> findActivePrice(
            @Param("brandId") Integer brandId,
            @Param("productId") Integer productId,
            @Param("priceStartDate") LocalDateTime priceStartDate
    );
}
