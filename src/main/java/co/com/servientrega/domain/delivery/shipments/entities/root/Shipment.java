package co.com.servientrega.domain.delivery.shipments.entities.root;

import co.com.servientrega.domain.delivery.shipments.entities.DeliveryOrder;
import co.com.servientrega.domain.delivery.shipments.entities.Invoice;
import co.com.servientrega.domain.delivery.shipments.entities.Package;
import co.com.servientrega.domain.delivery.shipments.events.*;
import co.com.servientrega.domain.delivery.shipments.identity.DeliveryOrderId;
import co.com.servientrega.domain.delivery.shipments.identity.InvoiceId;
import co.com.servientrega.domain.delivery.shipments.identity.PackageId;
import co.com.servientrega.domain.delivery.shipments.identity.ShipmentId;
import co.com.servientrega.domain.delivery.shipments.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Shipment extends AggregateEvent<ShipmentId> {
    private Invoice invoice;
    private Package item;
    private DeliveryOrder deliveryOrder;
    private Date sentAt;
    private Date deliveredAt;

    public Shipment(ShipmentId entityId) {
        super(entityId);
        subscribe(new ShipmentEventListener(this));
    }

    public Shipment(Invoice invoice, Package item, DeliveryOrder deliveryOrder, Date sentAt) {
        this(new ShipmentId(), invoice, item, deliveryOrder, sentAt, null);
    }

    public Shipment(ShipmentId entityId, Invoice invoice, Package item, DeliveryOrder deliveryOrder, Date sentAt, Date deliveredAt) {
        super(entityId);
        this.invoice = invoice;
        this.item = item;
        this.deliveryOrder = deliveryOrder;
        this.sentAt = sentAt;
        this.deliveredAt = deliveredAt;
        super.appendChange(new ShipmentCreated(this.identity())).apply();
    }

    public static Shipment from(ShipmentId id, List<DomainEvent> events) {
        Shipment shipment = new Shipment(id);
        events.forEach(shipment::applyEvent);
        return shipment;
    }

    public void addInvoice(ShipmentId shipmentId, InvoiceId invoiceId, /*todo ManagerId managerId,*/ Money calculatedCost) {
        super
                .appendChange(new InvoiceAdded(shipmentId, invoiceId, calculatedCost))
                .apply();
    }

    public void addDeliveryOrder(ShipmentId shipmentId, DeliveryOrderId deliveryOrderId, Sender sender, Addressee addressee) {
        super
                .appendChange(new DeliveryOrderAdded(shipmentId, deliveryOrderId, sender, addressee))
                .apply();
    }

    public void addPackage(ShipmentId shipmentId, PackageId packageId, PackageName packageName, PackageDescription packageDescription, Weight packageWeight, Size packageSize) {
        super
                .appendChange(new PackageAdded(shipmentId, packageId, packageName, packageDescription, packageWeight, packageSize))
                .apply();
    }

    public void changeAddressee(ShipmentId shipmentId, Addressee newAddressee) {
        super
                .appendChange(new AddresseeChanged(shipmentId, newAddressee))
                .apply();
    }

    public void calculateDeliveryCost(ShipmentId shipmentId, InvoiceId invoiceId, Money deliveryCost) {
        super
                .appendChange(new CalculatedDeliveryCost(shipmentId, invoiceId, deliveryCost))
                .apply();
    }

    public void changeInvoiceCost(ShipmentId shipmentId, InvoiceId invoiceId, Money newCost) {
        super
                .appendChange(new InvoiceCostChanged(shipmentId, invoiceId, newCost))
                .apply();
    }

    public void changePackageName(ShipmentId shipmentId, PackageId packageId, PackageName newPackageName) {
        super
                .appendChange(new PackageNameChanged(shipmentId, packageId, newPackageName))
                .apply();
    }

    public void changePackageDescription(ShipmentId shipmentId, PackageId packageId, PackageDescription newPackageDescription) {
        super
               .appendChange(new PackageDescriptionChanged(shipmentId, packageId, newPackageDescription))
               .apply();
    }

    public void changePackageSize(ShipmentId shipmentId, PackageId packageId, Size newPackageSize) {
        super
               .appendChange(new PackageSizeChanged(shipmentId, packageId, newPackageSize))
               .apply();
    }

    public void changePackageWeight(ShipmentId shipmentId, PackageId packageId, Weight newPackageWeight) {
        super
              .appendChange(new PackageWeightChanged(shipmentId, packageId, newPackageWeight))
              .apply();
    }

    public void deliverPackage(ShipmentId shipmentId, PackageId packageId) {
        super
                .appendChange(new PackageDelivered(shipmentId, packageId))
                .apply();
    }

    public Invoice invoice() {
        return invoice;
    }

    public Package item() {
        return item;
    }

    public DeliveryOrder deliveryOrder() {
        return deliveryOrder;
    }

    public Date sentAt() {
        return sentAt;
    }

    public Date deliveredAt() {
        return deliveredAt;
    }
}
