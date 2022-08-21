package co.com.servientrega.domain.usecases;

import co.com.servientrega.domain.delivery.shipments.commands.AddDeliveryOrder;
import co.com.servientrega.domain.delivery.shipments.entities.DeliveryOrder;
import co.com.servientrega.domain.delivery.shipments.entities.root.Shipment;
import co.com.servientrega.domain.delivery.shipments.identity.ShipmentId;
import co.com.servientrega.domain.delivery.shipments.values.Addressee;
import co.com.servientrega.domain.delivery.shipments.values.Sender;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AddDeliveryOrderUseCase extends UseCase<RequestCommand<AddDeliveryOrder>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddDeliveryOrder> addDeliveryOrderRequestCommand) {
        AddDeliveryOrder command = addDeliveryOrderRequestCommand.getCommand();
        ShipmentId shipmentId = command.shipmentId();
        Shipment shipment = Shipment.from(shipmentId, super.retrieveEvents(shipmentId.value()));
        Sender sender = new Sender("Pepito Perez", "3204545786", "93247983274", "Street 34 # 3 - 46");
        Addressee addressee = new Addressee("Juanito Gonzalez", "3098540568", "345345435234", "Street 56 # 1 - 34");
        DeliveryOrder deliveryOrder = new DeliveryOrder(sender, addressee);
        shipment.addDeliveryOrder(shipmentId, deliveryOrder.identity(), sender, addressee);

        super.emit().onResponse(new ResponseEvents(shipment.getUncommittedChanges()));
    }
}
