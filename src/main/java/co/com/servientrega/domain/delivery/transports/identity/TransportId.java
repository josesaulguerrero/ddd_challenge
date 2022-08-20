package co.com.servientrega.domain.delivery.transports.identity;

import co.com.servientrega.infrastructure.id.IdGenerationStrategy;
import co.com.servientrega.infrastructure.id.strategies.UUIDGenerationStrategy;
import co.com.sofka.domain.generic.Identity;
import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class TransportId extends Identity {
    private static final IdGenerationStrategy<String> idGenerationStrategy = new UUIDGenerationStrategy();
    private final String value;

    public TransportId() {
        this.value = idGenerationStrategy.generate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TransportId that = (TransportId) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}
