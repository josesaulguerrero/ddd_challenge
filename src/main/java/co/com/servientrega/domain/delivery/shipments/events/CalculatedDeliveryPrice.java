package co.com.servientrega.domain.delivery.shipments.events;

import co.com.servientrega.domain.delivery.shipments.identity.InvoiceId;
import co.com.servientrega.domain.delivery.shipments.values.Money;
import co.com.sofka.domain.generic.DomainEvent;

public class CalculatedDeliveryPrice extends DomainEvent {
    private final InvoiceId invoiceId;
    private final Money calculatedPrice;

    public CalculatedDeliveryPrice(InvoiceId invoiceId, Money calculatedPrice) {
        super("Servientrega.shipments.CalculatedDeliveryPrice");
        this.invoiceId = invoiceId;
        this.calculatedPrice = calculatedPrice;
    }

    public InvoiceId invoiceId() {
        return invoiceId;
    }

    public Money calculatedPrice() {
        return calculatedPrice;
    }
}
