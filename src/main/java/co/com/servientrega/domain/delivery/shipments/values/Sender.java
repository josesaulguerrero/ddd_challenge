package co.com.servientrega.domain.delivery.shipments.values;

import co.com.sofka.domain.generic.ValueObject;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Sender implements ValueObject<Sender.Props> {
    private final String fullName;
    private Integer age;
    private final String DNI;
    private String address;

    public interface Props {
        String fullName();
        Integer age();
        String DNI();
        String address();
    }

    @Override
    public Props value() {
        return new Props() {
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
