package local.inditex.ecommerce.domain.shared;

public abstract class AggregateRoot<T extends ValueObject<?>> {

    private final T id;

    protected AggregateRoot(final T id) {
        this.id = id;
    }

    protected T getId() {
        return id;
    }
}
