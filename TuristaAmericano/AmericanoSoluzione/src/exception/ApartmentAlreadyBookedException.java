package exception;

import entities.Apartment;
import entities.Booking;

import java.time.LocalDate;

public class ApartmentAlreadyBookedException extends Exception {
    public ApartmentAlreadyBookedException(Apartment apartment, Booking booking) {
        super("apartment " + apartment + " is already booked from " + booking.getStart() + " to " + booking.getEnd());
    }
}