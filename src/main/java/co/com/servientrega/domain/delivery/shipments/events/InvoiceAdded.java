package co.com.servientrega.domain.delivery.shipments.events;

import co.com.servientrega.domain.delivery.shipments.identity.InvoiceId;
import co.com.servientrega.domain.delivery.shipments.values.Money;
import co.com.sofka.domain.generic.DomainEvent;

public class InvoiceAdded extends DomainEvent {
    private final InvoiceId invoiceId;
    private final Money price;
    // todo private final ManagerId managerId;


    public InvoiceAdded(InvoiceId invoiceId, Money price) {
        super("Servientrega.shipments.InvoiceAdded");
        this.invoiceId = invoiceId;
        this.price = price;
    }

    public InvoiceId invoiceId() {
        return invoiceId;
    }

    public Money price() {
        return price;
    }
}
