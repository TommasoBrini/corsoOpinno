package exception;

import entities.Apartment;

public class ApartmentNotFoundException extends Throwable {
    public ApartmentNotFoundException(Apartment apartment) {
        super("apartment " + apartment + " not found");
    }
}