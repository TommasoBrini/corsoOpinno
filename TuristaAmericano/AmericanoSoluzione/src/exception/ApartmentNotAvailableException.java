package exception;

import entities.Apartment;

import java.time.LocalDate;

public class ApartmentNotAvailableException extends Throwable{
    public ApartmentNotAvailableException(Apartment apartment, LocalDate start, LocalDate end) {
        super("apartment " + " is not available for booking from " + start + "to " + end);
    }
}