package co.com.servientrega.domain.usecases;

import co.com.servientrega.domain.delivery.shipments.commands.CreateShipment;
import co.com.servientrega.domain.delivery.shipments.entities.root.Shipment;
import co.com.servientrega.domain.delivery.shipments.identity.ShipmentId;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CreateShipmentUseCase extends UseCase<RequestCommand<CreateShipment>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateShipment> createShipmentRequestCommand) {
        CreateShipment command = createShipmentRequestCommand.getCommand();
        Shipment shipment = new Shipment(new ShipmentId(), command.sentAt(), null);

        super.emit().onResponse(new ResponseEvents(shipment.getUncommittedChanges()));
    }
}
