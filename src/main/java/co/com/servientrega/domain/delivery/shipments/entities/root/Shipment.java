package co.com.servientrega.domain.delivery.shipments.entities.root;

import co.com.servientrega.domain.delivery.shipments.entities.DeliveryOrder;
import co.com.servientrega.domain.delivery.shipments.entities.Invoice;
import co.com.servientrega.domain.delivery.shipments.entities.Package;
import co.com.servientrega.domain.delivery.shipments.identity.ShipmentId;
import co.com.servientrega.domain.delivery.shipments.values.Date;
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
    }

    public Shipment(Invoice invoice, Package item, DeliveryOrder deliveryOrder, Date sentAt, Date deliveredAt) {
        this(new ShipmentId(), invoice, item, deliveryOrder, sentAt, null);
    }

    public Shipment(ShipmentId entityId, Invoice invoice, Package item, DeliveryOrder deliveryOrder, Date sentAt, Date deliveredAt) {
        super(entityId);
        this.invoice = invoice;
        this.item = item;
        this.deliveryOrder = deliveryOrder;
        this.sentAt = sentAt;
        this.deliveredAt = deliveredAt;
    }

    public static Shipment from(ShipmentId id, List<DomainEvent> events) {
        Shipment shipment = new Shipment(id);
        events.forEach(shipment::applyEvent);
        return shipment;
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
