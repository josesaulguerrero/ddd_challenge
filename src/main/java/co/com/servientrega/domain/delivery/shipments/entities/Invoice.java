package co.com.servientrega.domain.delivery.shipments.entities;

import co.com.servientrega.domain.delivery.shipments.identity.InvoiceId;
import co.com.servientrega.domain.delivery.shipments.values.Money;
import co.com.sofka.domain.generic.Entity;

public class Invoice extends Entity<InvoiceId> {
    //todo private final Manager issuedBy;
    private Money cost;

    public Invoice(InvoiceId entityId, Money cost) {
        super(entityId);
        this.cost = cost;
    }

    public void changeCost(Money newCost) {
        this.cost = newCost;
    }

    public Invoice(Money cost) {
        this(new InvoiceId(), cost);
    }

    public Money cost() {
        return cost;
    }
}
