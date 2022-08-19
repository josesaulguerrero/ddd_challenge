package co.com.servientrega.domain.infrastructure.id;

public interface IdGenerationStrategy<T> {
    T generate();
}
