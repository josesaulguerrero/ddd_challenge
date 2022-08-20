package co.com.servientrega.domain.delivery.transports.identity;

import co.com.servientrega.infrastructure.id.IdGenerationStrategy;
import co.com.servientrega.infrastructure.id.strategies.UUIDGenerationStrategy;
import co.com.sofka.domain.generic.Identity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TransportId extends Identity {
    private static final IdGenerationStrategy<String> idGenerationStrategy = new UUIDGenerationStrategy();
    private final String value;

    public TransportId() {
        this.value = idGenerationStrategy.generate();
    }
}
