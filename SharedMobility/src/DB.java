import Dao.DaoUser;
import Dao.DaoVehicle;
import Dao.implement.DaoUserCsv;
import Dao.implement.DaoVehicleCsv;
import Model.User;
import Model.Vehicle;
import lombok.Getter;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//DB con Singleton
@Getter
public class DB {
    private static DB Internalinstance;
    private List<User> user;
    private List<Vehicle> vehicle;
    private DaoUser userDao;
    private DaoVehicle vehicleDao;

    private DB(){
        user = new ArrayList<>();
        vehicle = new ArrayList<>();
        userDao = new DaoUserCsv(Paths.get("src","Dao","implement","users.csv"));
        vehicleDao = new DaoVehicleCsv(Paths.get("src", "Dao", "implement", "vehicle.csv"));
    }

    public static DB getInstance(){
        if(Internalinstance == null){
            Internalinstance = new DB();
        }
        return Internalinstance;
    }

    //metodi User
    public void addUser(User user) {
        userDao.insert(user);
    }
    public void removeUser(UUID id) {
        userDao.delete(id);
    }
    public void updateUser(User user) {
        userDao.update(user);
    }
    public User getUser(UUID id) {
        return userDao.get(id);
    }
    public List<User> getAllUsers() {
        return userDao.getAll();
    }


    //metodi Vehicle
    public void addVehicle(Vehicle vehicle) {
        vehicleDao.insert(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        vehicleDao.delete(vehicle);
    }
    public void updateVehicle(Vehicle vehicle) {
        vehicleDao.update(vehicle);
    }
    public Vehicle getVehicle(UUID id) {
        return vehicleDao.get(id);
    }
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.getAll();
    }


    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicle) {
            if (vehicle.getUserID() == null) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }
}


