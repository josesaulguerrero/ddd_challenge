package co.com.servientrega.domain.delivery.shipments.values;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Date {
    private LocalDateTime value;

    public Date() {
        this.value = LocalDateTime.now();
    }

    public static Date of(LocalDateTime value) {
        return new Date(value);
    }
    
    public static Date now() {
        return Date.of(LocalDateTime.now());
    }

    public LocalDateTime value() {
        return value;
    }
}
