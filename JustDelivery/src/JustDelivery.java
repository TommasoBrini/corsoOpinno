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

    /**
     * ricerca all'interno della lista dei ristoranti tutti i ristoranti che contengono la cucina specificata.
     * @param cucina TipoCucina da ricercare.
     * @return la lista dei ristoranti con la cucina selezionata.
     */
    public List<Ristorante> cercaRistorantiCucina(TipoCucina cucina){
        List<Ristorante> res = new ArrayList<>();
        for (Ristorante ristorante : ristoranti) {
            List<TipoCucina> cucine = ristorante.getTipoCucina();
            if(cucine.contains(cucina)){
                res.add(ristorante);
            }
        }
        return res;
    }

}
