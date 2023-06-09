import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tripleton {
    private static List<Tripleton> internalInstance = new ArrayList<>();

    private static int n;

    private Tripleton(int n) {
        this.n = n;
    }

    public static Tripleton getIstance(){

        if(internalInstance.size() < 3) {
            internalInstance.add(new Tripleton(internalInstance.size()));
        }
        int i = new Random().nextInt(0, internalInstance.size());
        return internalInstance.get(i);
    }

    public static List<Tripleton> getTripleton(){
        return internalInstance;
    }


}
