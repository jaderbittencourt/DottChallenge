package bittencourt.jader.dottchallenge.generator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.concurrent.ThreadLocalRandom;

public class PlacedOrderDate {

    private static final long minDay = LocalDate.of(2018, Month.OCTOBER.getValue(), 1).toEpochDay();
    private static final long maxDay = LocalDate.now().toEpochDay();

    public static LocalDateTime getRandomPlacedOrderDate() {
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return LocalDateTime.of(randomDate, LocalTime.now());
    }
}
