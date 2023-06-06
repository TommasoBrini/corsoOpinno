package exception;

import entities.Apartment;

public class AvailabilitiesOverlapException extends Throwable {
    public AvailabilitiesOverlapException(Apartment.Availability newAvailability, Apartment.Availability avail) {
        super(newAvailability + " overlaps with " + avail);
    }
}