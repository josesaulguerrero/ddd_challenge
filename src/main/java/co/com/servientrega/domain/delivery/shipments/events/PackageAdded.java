package co.com.servientrega.domain.delivery.shipments.events;

import co.com.servientrega.domain.delivery.shipments.identity.PackageId;
import co.com.servientrega.domain.delivery.shipments.values.PackageDescription;
import co.com.servientrega.domain.delivery.shipments.values.PackageName;
import co.com.servientrega.domain.delivery.shipments.values.Size;
import co.com.servientrega.domain.delivery.shipments.values.Weight;
import co.com.sofka.domain.generic.DomainEvent;

public class PackageAdded extends DomainEvent {
    private final PackageId packageId;
    private final PackageName packageName;
    private final PackageDescription packageDescription;
    private final Weight packageWeight;
    private final Size packageSize;

    public PackageAdded(PackageId packageId, PackageName packageName, PackageDescription packageDescription, Weight packageWeight, Size packageSize) {
        super("Servientrega.shipments.PackageAdded");
        this.packageId = packageId;
        this.packageName = packageName;
        this.packageDescription = packageDescription;
        this.packageWeight = packageWeight;
        this.packageSize = packageSize;
    }

    public PackageId packageId() {
        return packageId;
    }

    public PackageName packageName() {
        return packageName;
    }

    public PackageDescription packageDescription() {
        return packageDescription;
    }

    public Weight packageWeight() {
        return packageWeight;
    }

    public Size packageSize() {
        return packageSize;
    }
}
