package local.inditex.ecommerce.domain.shared;

public abstract class Entity<T extends ValueObject<?>> {

    private final T id;

    protected Entity(final T id) {
        this.id = id;
    }

    protected T getId() {
        return id;
    }
}
