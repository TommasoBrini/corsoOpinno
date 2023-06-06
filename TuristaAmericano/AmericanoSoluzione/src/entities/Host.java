package entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import exception.ApartmentNotFoundException;
import exception.AvailabilitiesOverlapException;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Host extends User {
    @NonNull
    private UUID codiceHost;
    private final Set<Apartment> apartments = new HashSet<>();

    public boolean addApartment(Apartment apartment){
        return apartments.add(apartment);
    }

    public boolean addAvailability(Apartment.Availability availability) throws ApartmentNotFoundException, AvailabilitiesOverlapException {
        Apartment apartment = availability.getApartment();
        if (!apartments.contains(apartment)) throw new ApartmentNotFoundException(apartment);
        return apartment.addAvailability(availability);
    }

    public static Host fromUser(User user){
        return Host.builder()
                .codiceHost(UUID.randomUUID())
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .surname(user.getSurname())
                .address(user.getAddress())
                .build();
    }
}