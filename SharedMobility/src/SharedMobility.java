import Model.*;
import Model.Vehicles.*;

import java.util.List;

public class SharedMobility {
    private DB db;

    public SharedMobility() {
        db= DB.getInstance();
    }

    public void signinUser(User user) {
        db.addUser(user);
    }

    public void addVehicle(Vehicle vehicle){
        db.addVehicle(vehicle);
    }

    public void addCreditUser(User test,int credit){
        User user=db.getUser(test.getID());
        user.setCredit((user.getCredit())+credit);
        db.updateUser(user);
    }

    public List<Vehicle> searchVehicle() {
        return db.getAvailableVehicles();
    }

    public void rentVehicle(Vehicle testVehicle, User testUser,int minute) {
        User user=db.getUser(testUser.getID());
        Vehicle vehicle=db.getVehicle(testVehicle.getID());

        //Controllo del tempo
        if(minute<=5){
            System.out.println("Tempo non sufficente");
            return;
        }

        // Controllo se il veicolo è disponibile
        if (vehicle.getUserID() != null) {
            System.out.println("Il veicolo non è disponibile.");
            return;
        }

        //Controllo del saldo
        if((vehicle.getRateXMinute()*minute)>user.getCredit()){
            System.out.println("Credito non sufficente");
            return;
        }

        // Controllo se l'utente è già presente in un altro veicolo
        for (Vehicle v : db.getAllVehicles()) {
            if (v.getUserID() != null && v.getUserID().equals(user.getID())) {
                System.out.println("L'utente è già presente in un altro veicolo.");
                return;
            }
        }

        // Controllo specifico per Scooter e Bicicletta
        if (vehicle instanceof Scooter || vehicle instanceof Bicycle) {
            // Controllo se l'utente possiede il casco
            if(vehicle instanceof Scooter) {
                if (!user.getHelmet().equals(Helmet.SCOOTER)) {
                    System.out.println("L'utente deve possedere un casco per noleggiare uno Scooter.");
                    return;
                }
            }else{
                if(!user.getHelmet().equals(Helmet.BIKE)){
                    System.out.println("L'utente deve possedere un casco per noleggiare una Bicicletta.");
                    return;
                }
            }
        } else {

            // Controllo se la patente del veicolo corrisponde alla patente dell'utente
            if (vehicle instanceof Car) {
                if (!user.getDrivingLicenses().contains(DrivingLicense.B) && !user.getDrivingLicenses().contains(DrivingLicense.BSPECIAL)) {
                    System.out.println("La patente dell'utente non corrisponde alla patente del veicolo.");
                    return;
                }
            } else if (vehicle instanceof MotoScooter) {
                if (!user.getDrivingLicenses().contains(DrivingLicense.A) && !user.getDrivingLicenses().contains(DrivingLicense.ASPECIAL)) {
                    System.out.println("La patente dell'utente non corrisponde alla patente del veicolo.");
                    return;
                }
            } else if (vehicle instanceof Van) {
                if (!user.getDrivingLicenses().contains(DrivingLicense.C) && !user.getDrivingLicenses().contains(DrivingLicense.CSPECIAL)) {
                    System.out.println("La patente dell'utente non corrisponde alla patente del veicolo.");
                    return;
                }
            }
        }

        // Veicolo disponibile e utente idoneo, procedi con il noleggio
        vehicle.setUserID(user.getID());
        user.setCredit((user.getCredit()-(vehicle.getRateXMinute()*minute)));
        db.updateVehicle(vehicle);
        db.updateUser(user);
        System.out.println("Veicolo affittato con successo.");

    }

    public void returnVehicle(Vehicle test) {
        // Controllo se il veicolo è stato noleggiato
        Vehicle vehicle=db.getVehicle(test.getID());
        if (vehicle.getUserID() == null) {
            System.out.println("Il veicolo non è stato noleggiato.");
            return;
        }

        // Cerca l'utente in base all'ID del veicolo
        User user = null;
        for (User u : db.getAllUsers()) {
            if (u.getID().equals(vehicle.getUserID())) {
                user = u;
                break;
            }
        }

        if (user == null) {
            System.out.println("Impossibile trovare l'utente associato al veicolo.");
            return;
        }

        // Rimuovi l'ID dell'utente dal veicolo
        vehicle.setUserID(null);
        db.updateVehicle(vehicle);

        System.out.println("Veicolo restituito con successo.");
    }

    public List<Vehicle> getVehicles(){
        return db.getAllVehicles();
    }

}
