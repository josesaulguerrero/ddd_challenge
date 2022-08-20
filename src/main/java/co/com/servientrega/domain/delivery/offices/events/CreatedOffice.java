package co.com.servientrega.domain.delivery.offices.events;

import co.com.servientrega.domain.delivery.common.values.Date;
import co.com.servientrega.domain.delivery.offices.identity.OfficeId;
import co.com.sofka.domain.generic.DomainEvent;

public class CreatedOffice extends DomainEvent {
    private final OfficeId officeId;
    private final Date createdAt;

    public CreatedOffice(OfficeId officeId, Date createdAt) {
        super("Servientrega.offices.CreatedOffice");
        this.officeId = officeId;
        this.createdAt = createdAt;
    }

    public OfficeId officeId() {
        return officeId;
    }

    public Date createdAt() {
        return createdAt;
    }
}
