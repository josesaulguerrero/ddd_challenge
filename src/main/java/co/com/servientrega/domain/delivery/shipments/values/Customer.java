package co.com.servientrega.domain.delivery.shipments.values;

import co.com.sofka.domain.generic.ValueObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Customer implements ValueObject<Sender.Props> {
    private String fullName;
    private Integer age;
    private String DNI;
    private String address;

    public interface Props {
        String fullName();

        Integer age();

        String DNI();

        String address();
    }

    @Override
    public Sender.Props value() {
        return new Sender.Props() {
            @Override
            public String fullName() {
                return fullName;
            }

            @Override
            public Integer age() {
                return age;
            }

            @Override
            public String DNI() {
                return DNI;
            }

            @Override
            public String address() {
                return address;
            }
        };
    }
}
