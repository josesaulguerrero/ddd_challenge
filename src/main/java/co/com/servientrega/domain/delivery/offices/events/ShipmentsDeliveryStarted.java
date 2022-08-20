package co.com.servientrega.domain.delivery.offices.events;

import co.com.servientrega.domain.delivery.offices.identity.OfficeId;
import co.com.servientrega.domain.delivery.offices.identity.StoreId;
import co.com.servientrega.domain.delivery.shipments.identity.ShipmentId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Set;

public class ShipmentsDeliveryStarted extends DomainEvent {
    // todo private final TransportId transportId;
    private final OfficeId officeId;
    private final StoreId storeId;
    private final Set<ShipmentId> shipmentsIds;

    public ShipmentsDeliveryStarted(OfficeId officeId, StoreId storeId, Set<ShipmentId> shipmentsIds) {
        super("Servientrega.offices.ShipmentsDeliveryStarted");
        this.officeId = officeId;
        this.storeId = storeId;
        this.shipmentsIds = shipmentsIds;
    }

    public OfficeId officeId() {
        return officeId;
    }

    public StoreId storeId() {
        return storeId;
    }

    public Set<ShipmentId> shipmentsIds() {
        return shipmentsIds;
    }
}
