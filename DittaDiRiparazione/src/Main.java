import java.security.cert.URICertStoreParameters;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DittaRipazioni dittaRipazioni = new DittaRipazioni(new TecniciList());
        Tecnico tec1 = new Tecnico("Mario");
        Tecnico tec2 = new Tecnico("Luigi");
        Riparazione rip = new Riparazione("Via Brombeis", 3);
        Riparazione rip2 = new Riparazione("giovanii", 5);

        //Aggiungo riparazioni in attesa
        dittaRipazioni.addRiparazione(rip);
        dittaRipazioni.addRiparazione(rip2);

        //Assegno riparazione a Mario, ma Mario non c'è ancora
        dittaRipazioni.assegnaRiparazione("Mario");

        //aggiungo tecnici
        dittaRipazioni.addTec(tec1);
        dittaRipazioni.addTec(tec2);

        //Assegmp riparazione a Luigi
        dittaRipazioni.assegnaRiparazione("Luigi");

        //ferie Mario
        dittaRipazioni.mandaFerie("Mario");
        //è già in ferie
        dittaRipazioni.assegnaRiparazione("Mario");
        dittaRipazioni.assegnaRiparazione("Luigi");

    }
}