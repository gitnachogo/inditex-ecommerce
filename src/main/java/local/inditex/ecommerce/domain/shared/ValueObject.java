package local.inditex.ecommerce.domain.shared;

import java.util.Objects;

public abstract class ValueObject<T> {

    private final T value;
    private static final String NULL_VALUE_OBJECT_MESSAGE = "A value object can not be null";

    protected ValueObject(final T value) {
        this.value = value;
        this.ensureIsNotNull(value);
    }

    public T getValue() {
        return this.value;
    }

    private void ensureIsNotNull(final T value) {
        if (value == null) {
            throw new IllegalArgumentException(NULL_VALUE_OBJECT_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueObject<?> that = (ValueObject<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
