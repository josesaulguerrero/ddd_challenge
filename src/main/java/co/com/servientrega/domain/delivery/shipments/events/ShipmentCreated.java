package co.com.servientrega.domain.delivery.shipments.events;

import co.com.servientrega.domain.delivery.shipments.identity.ShipmentId;
import co.com.sofka.domain.generic.DomainEvent;

public class ShipmentCreated extends DomainEvent {
    private final ShipmentId shipmentId;

    public ShipmentCreated(ShipmentId shipmentId) {
        super("Servientrega.shipments.ShipmentCreated");
        this.shipmentId = shipmentId;
    }

    public ShipmentId shipmentId() {
        return shipmentId;
    }
}
