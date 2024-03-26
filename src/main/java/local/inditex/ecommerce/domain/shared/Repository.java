package local.inditex.ecommerce.domain.shared;

import java.util.List;

public interface Repository<T extends AggregateRoot<?>, S extends ValueObject<?>> {

    T findById(final S id);

    List<T> findAll();

    void create(final T aggregateRoot);

    void update(final T aggregateRoot);

    void delete(final T aggregateRoot);

}
