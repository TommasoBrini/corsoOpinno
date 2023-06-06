import java.util.ArrayList;
import java.util.List;

public class JustDelivery {
    //Lista dei ristoranti
    List<Ristorante> ristoranti = new ArrayList<>();

    //Lista degli utenti
    List<Utente> utenti = new ArrayList<>();

    /**
     * Registrazione utente nell'app
     * @param utente utente da registrare
     */
    public void registrazioneUtente(Utente utente){
        utenti.add(utente);
    }

    /**
     * Registrazione ristorante nell'app
     * @param ristorante ristorante da registrare
     */
    public void registrazioneRistorante(Ristorante ristorante){
        ristoranti.add(ristorante);
    }

    /**
     * Setta il menu di un ristorante
     * @param ristorante ristorante specificato
     * @param prods prodotti da aggiungere al menu del ristorante
     */
    public void setMenu(Ristorante ristorante, List<Prodotto> prods){
        for (Ristorante rist : ristoranti) {
            if(rist.equals(ristorante)){
                rist.setMenu(prods);
            }
        }
    }

    public

}
