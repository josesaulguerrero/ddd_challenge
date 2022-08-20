package co.com.servientrega.domain.delivery.shipments.commands;

import co.com.servientrega.domain.delivery.shipments.identity.ShipmentId;
import co.com.servientrega.domain.delivery.shipments.values.Money;
import co.com.sofka.domain.generic.Command;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddInvoice extends Command {
    private final ShipmentId shipmentId;
    // Todo private final ManagerId managerId;
    private final Money calculatePrice; // todo calculate price based on package size and weight?

    public ShipmentId shipmentId() {
        return shipmentId;
    }

    //todo add mangerid getter

    public Money calculatePrice() {
        return calculatePrice;
    }
}
