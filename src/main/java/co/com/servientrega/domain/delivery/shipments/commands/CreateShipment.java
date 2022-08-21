package co.com.servientrega.domain.delivery.shipments.commands;

import co.com.servientrega.domain.delivery.common.identity.EmployeeId;
import co.com.servientrega.domain.delivery.common.values.Size;
import co.com.servientrega.domain.delivery.common.values.Weight;
import co.com.servientrega.domain.delivery.shipments.values.*;
import co.com.sofka.domain.generic.Command;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateShipment extends Command {
    private final EmployeeId issuerId;
    private final Sender sender;
    private final Addressee addressee;
    private final PackageName packageName;
    private final PackageDescription packageDescription;
    private final Weight packageWeight;
    private final Size packageSize;

    public EmployeeId issuerId() {
        return issuerId;
    }

    public Sender sender() {
        return sender;
    }

    public Addressee addressee() {
        return addressee;
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
