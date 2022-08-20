package co.com.servientrega.domain.delivery.offices.events;

import co.com.servientrega.domain.delivery.offices.identity.OfficeId;
import co.com.servientrega.domain.delivery.offices.identity.StoreId;
import co.com.sofka.domain.generic.DomainEvent;

public class StoreAdded extends DomainEvent {
    private final OfficeId officeId;
    private final StoreId storeId;

    public StoreAdded(OfficeId officeId, StoreId storeId) {
        super("Servientrega.offices.StoreAdded");
        this.officeId = officeId;
        this.storeId = storeId;
    }

    public OfficeId officeId() {
        return officeId;
    }

    public StoreId storeId() {
        return storeId;
    }
}
