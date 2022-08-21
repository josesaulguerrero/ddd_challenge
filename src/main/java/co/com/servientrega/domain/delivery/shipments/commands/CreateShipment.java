package co.com.servientrega.domain.delivery.shipments.commands;

import co.com.servientrega.domain.delivery.common.values.Date;
import co.com.sofka.domain.generic.Command;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateShipment extends Command {
    private final Date sentAt;

    public Date sentAt() {
        return sentAt;
    }
}
