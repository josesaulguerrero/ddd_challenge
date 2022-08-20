package co.com.servientrega.domain.delivery.shipments.events;

import co.com.servientrega.domain.delivery.shipments.identity.PackageId;
import co.com.sofka.domain.generic.DomainEvent;

public class PackageDelivered extends DomainEvent {
    private final PackageId packageId;

    public PackageDelivered(PackageId packageId) {
        super("Servientrega.shipments.PackageDelivered");
        this.packageId = packageId;
    }

    public PackageId packageId() {
        return packageId;
    }
}
