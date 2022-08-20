package co.com.servientrega.domain.delivery.offices.events;

import co.com.servientrega.domain.delivery.common.identity.EmployeeId;
import co.com.servientrega.domain.delivery.offices.identity.OfficeId;
import co.com.sofka.domain.generic.DomainEvent;

public class ManagerChanged extends DomainEvent {
    private final OfficeId officeId;
    private final EmployeeId previousManagerId;

    public ManagerChanged(OfficeId officeId, EmployeeId previousManagerId) {
        super("Servientrega.offices.ManagerChanged");
        this.officeId = officeId;
        this.previousManagerId = previousManagerId;
    }

    public OfficeId officeId() {
        return officeId;
    }

    public EmployeeId previousManagerId() {
        return previousManagerId;
    }
}
