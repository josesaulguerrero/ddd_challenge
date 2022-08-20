package co.com.servientrega.domain.delivery.transports.events;

import co.com.servientrega.domain.delivery.common.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class DeliveryAssistantAdded extends DomainEvent {
    private final DNI dni;
    private final FullName fullName;
    private final Email email;
    private final PhoneNumber phoneNumber;
    private final Salary salary;

    public DeliveryAssistantAdded(DNI dni, FullName fullName, Email email, PhoneNumber phoneNumber, Salary salary) {
        super("Servientrega.transports.DeliveryAssistantAdded");
        this.dni = dni;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public DNI dni() {
        return dni;
    }

    public FullName fullName() {
        return fullName;
    }

    public Email email() {
        return email;
    }

    public PhoneNumber phoneNumber() {
        return phoneNumber;
    }

    public Salary salary() {
        return salary;
    }
}
