package co.com.servientrega.domain.infrastructure.id.strategies;

import co.com.servientrega.domain.infrastructure.id.IdGenerationStrategy;

import java.util.UUID;

public class UUIDGenerationStrategy implements IdGenerationStrategy<String> {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
