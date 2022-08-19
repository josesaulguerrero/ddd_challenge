package co.com.servientrega.domain.delivery.shipments.values;

import co.com.sofka.domain.generic.ValueObject;

public class DeliveryOrderId implements ValueObject<Long> {
    private static Long idCount = 0L;
    private final Long value;

    public DeliveryOrderId() {
        this.value = idCount++;
    }

    @Override
    public Long value() {
        return this.value;
    }
}
