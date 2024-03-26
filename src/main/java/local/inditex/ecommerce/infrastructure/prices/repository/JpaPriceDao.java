package local.inditex.ecommerce.infrastructure.prices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPriceDao extends JpaRepository<PriceDto, Integer> {
}
