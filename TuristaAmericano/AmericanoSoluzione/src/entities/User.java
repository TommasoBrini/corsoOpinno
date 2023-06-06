package entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import exception.BookingNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @NonNull
    @EqualsAndHashCode.Include
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private final List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) { bookings.add(booking); }

    public void leaveFeedback(Booking booking, Feedback feedback) throws BookingNotFoundException {
        for (Booking booking1 : bookings) {
            if(booking.equals(booking1))
                booking.getApartment().addFeedback(feedback);
        }
        throw new BookingNotFoundException(this, booking);
    }
}