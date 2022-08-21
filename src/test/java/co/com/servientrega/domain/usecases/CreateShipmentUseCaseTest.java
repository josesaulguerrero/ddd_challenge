package co.com.servientrega.domain.usecases;

import co.com.servientrega.domain.delivery.common.identity.EmployeeId;
import co.com.servientrega.domain.delivery.common.values.*;
import co.com.servientrega.domain.delivery.shipments.commands.CreateShipment;
import co.com.servientrega.domain.delivery.shipments.events.ShipmentCreated;
import co.com.servientrega.domain.delivery.shipments.values.Addressee;
import co.com.servientrega.domain.delivery.shipments.values.PackageDescription;
import co.com.servientrega.domain.delivery.shipments.values.PackageName;
import co.com.servientrega.domain.delivery.shipments.values.Sender;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class CreateShipmentUseCaseTest {
    private final String randomUUID = generateRandomUUID();

    @Test
    @DisplayName("Test for CreateShipmentUseCase#executeUseCase")
    void executeUseCase() {
        // Arrange
        EmployeeId issuerId = new EmployeeId();
        Sender sender = new Sender("Pepito Suarez", "3420384923", "24343830", "Street 34 # 45 - 34");
        Addressee addressee = new Addressee("Juanito Gonzales", "324324234", "657474653", "Street 23 # 123 - 67");
        PackageName packageName = new PackageName("Apple Seeds");
        PackageDescription packageDescription = new PackageDescription("Seeds of a healthy apple tree.");
        Weight packageWeight = new Weight(0.1);
        Size packageSize = new Size(0.1, 0.1, 0.1);
        CreateShipment command = new CreateShipment(issuerId, sender, addressee, packageName, packageDescription, packageWeight, packageSize);
        CreateShipmentUseCase useCase = new CreateShipmentUseCase();

        // Act
        ShipmentCreated event = (ShipmentCreated) UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(randomUUID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new RuntimeException("Something went wrong while creating the shipment."))
                .getDomainEvents()
                .get(0);

        // Assert
        Assertions.assertThat(event.shipmentId()).isNotNull();
        Assertions.assertThat(event.sentAt().value()).isBefore(LocalDateTime.now());
        Assertions.assertThat(event.deliveredAt().value()).isNull();
    }

    private static String generateRandomUUID() {
        return UUID.randomUUID().toString();
    }
}