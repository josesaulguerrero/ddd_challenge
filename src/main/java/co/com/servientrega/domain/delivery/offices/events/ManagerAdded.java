package co.com.servientrega.domain.delivery.offices.events;

import co.com.servientrega.domain.delivery.common.identity.EmployeeId;
import co.com.servientrega.domain.delivery.offices.identity.OfficeId;
import co.com.sofka.domain.generic.DomainEvent;

public class ManagerAdded extends DomainEvent {
    private final OfficeId officeId;

    private final EmployeeId managerId;

    public ManagerAdded(OfficeId officeId, EmployeeId managerId) {
        super("Servientrega.offices.ManagerAdded");
        this.officeId = officeId;
        this.managerId = managerId;
    }

    public OfficeId officeId() {
        return officeId;
    }

    public EmployeeId managerId() {
        return managerId;
    }
}
