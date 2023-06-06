package exception;

import entities.Booking;
import entities.User;

public class BookingNotFoundException extends Throwable{
    public BookingNotFoundException(User user, Booking booking){
        super("user " + user + " never booked " + booking);
    }
}
