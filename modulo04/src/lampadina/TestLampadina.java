package lampadina;

import java.util.Scanner;

public class TestLampadina {
    public static void main(String[] args) {
        Impianto imp = new Impianto(true);
        Lampadina lamp = new Lampadina(imp);
        lamp.click();
        System.out.println("Stato: " + lamp.statoLampadina());
        lamp.click();
        System.out.println("Stato: " + lamp.statoLampadina());
        lamp.click();
        System.out.println("SPENGO LA CORRENTE");
        imp.generatore();
        System.out.println("Stato: " + lamp.statoLampadina());
        lamp.click();
        System.out.println("Stato: " + lamp.statoLampadina());
        lamp.click();
        System.out.println("ACCENDO LA CORRENTE");
        imp.generatore();
        System.out.println("Stato: " + lamp.statoLampadina());
        lamp.click();
        System.out.println("Stato: " + lamp.statoLampadina());




        /*
        Interruttore inter1 = new Interruttore(lamp);

        Interruttore inter2 = new Interruttore(lamp);
        Scanner sc = new Scanner(System.in);
        boolean test = true;
        while(test){
            System.out.println("Stato Lampadina: " + lamp.statoLampadina());
            System.out.println("Cosa vuoi fare?");
            System.out.println("Clicca interruttore1 (1), interruttore2 (2) o esci (3)");
            switch (sc.nextInt()){
                case 1:
                    System.out.println("Interruttore 1 premuto");
                    inter1.click();
                    break;
                case 2:
                    System.out.println("Interruttore 2 premuto");
                    inter2.click();
                    break;
                case 3:
                    System.out.println("Esci");
                    test=false;
                    break;
            }
        }*/
    }
}
