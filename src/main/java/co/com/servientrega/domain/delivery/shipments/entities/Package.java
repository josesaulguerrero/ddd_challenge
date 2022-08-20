package co.com.servientrega.domain.delivery.shipments.entities;

import co.com.servientrega.domain.delivery.shipments.identity.PackageId;
import co.com.servientrega.domain.delivery.shipments.values.PackageDescription;
import co.com.servientrega.domain.delivery.shipments.values.PackageName;
import co.com.servientrega.domain.delivery.shipments.values.Size;
import co.com.servientrega.domain.delivery.shipments.values.Weight;
import co.com.sofka.domain.generic.Entity;

public class Package extends Entity<PackageId> {
    private PackageName name;
    private PackageDescription description;
    private Weight weight;
    private Size size;

    public Package(PackageId entityId, PackageName name, PackageDescription description, Weight weight, Size size) {
        super(entityId);
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.size = size;
    }

    public Package(PackageName name, PackageDescription description, Weight weight, Size size) {
        this(new PackageId(), name, description, weight, size);
    }

    public void changeName(String name) {
        this.name = new PackageName(name);
    }

    public void changeDescription(String description) {
        this.description = new PackageDescription(description);
    }

    public void changeWeight(Double weight) {
        this.weight = new Weight(weight);
    }

    public void changeSize(Double height, Double width, Double length) {
        this.size = new Size(height, width, length);
    }

    public PackageName packageName() {
        return name;
    }

    public PackageDescription packageDescription() {
        return description;
    }

    public Weight packageWeight() {
        return weight;
    }

    public Size packageSize() {
        return size;
    }
}
