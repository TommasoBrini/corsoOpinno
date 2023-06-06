package entities;

import lombok.*;
import exception.AvailabilitiesOverlapException;
import exception.IllegalPeriodException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Apartment {
    @EqualsAndHashCode.Include
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String address;
    private int nRoom;  // >0
    private int nBeds;  // >0
    private int floor;  // >=0
    private Host host;
    private final List<Booking> bookings = new ArrayList<>();
    private final List<Feedback> feedbacks = new ArrayList<>();
    private final List<Availability> availabities = new ArrayList<>();

    public void addBooking(Booking booking){bookings.add(booking);}

    public boolean addAvailability(Availability newAvailability) throws AvailabilitiesOverlapException {
        LocalDate start = newAvailability.start;
        LocalDate end = newAvailability.end;
        for (Availability avail : availabities){
            boolean availabilitiesOverlap = start.isBefore(avail.end) || end.isAfter(avail.start);
            if (availabilitiesOverlap) throw new AvailabilitiesOverlapException(newAvailability, avail);
        }
        return availabities.add(newAvailability);
    }

    public boolean addFeedback(Feedback feedback) { return feedbacks.add(feedback); }

    @Getter
    public class Availability{
        private double pricePerNight;  // > 0
        @NonNull private LocalDate start;
        @NonNull private LocalDate end;

        public Availability(double pricePerNight, @NonNull LocalDate start, @NonNull LocalDate end) {
            if(start.isAfter(end)) throw new IllegalPeriodException(start, end);
            if (pricePerNight <= 0) throw new IllegalArgumentException("pricePerNight must be >0");

            this.pricePerNight = pricePerNight;
            this.start = start;
            this.end = end;
        }

        public Apartment getApartment() { return Apartment.this; }
    }
}