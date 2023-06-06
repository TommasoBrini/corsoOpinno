package exception;

import lombok.NonNull;

import java.time.LocalDate;

public class IllegalPeriodException extends RuntimeException {
    public IllegalPeriodException(LocalDate start, LocalDate end) {
        super("start date " + start + " end date " + end);
    }
}