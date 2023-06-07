import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/***
 * ## JustDelivery
 *
 * E' stata commissionata la realizzazione di un sistema per gestire un'app di food delivery
 *
 * Nell'app sono presenti
 * gli utenti
 * i ristoranti
 * ogni ristorante ha un menu e uno o più tipi di cucina
 * un utente può fare un ordine da un singolo ristorante scegliendo almeno uno dei prodotti nel menu
 *
 * # Funzioni 1
 * * Registrazione utente
 * * Registrazione ristorante
 * * Inserimento menu del ristorante
 * * Ricerca dei ristoranti per tipo di cucina
 * * Stampa del menu su console
 * * Aggiunta dei prodotti all'ordine
 * * Stampa del dettaglio dell'ordine (lista prodotti, prezzo totale calcolando le spese di consegna)
 * * Ottenere lo storico degli ordini di un utente
 *
 * # Funzioni 2
 * * Ottenere i ristoranti dai quali un utente ha effettuato un ordine, ordinati per quantità di ordini effettuati dall'utente
 * * Ottenere la cucina più apprezzata dall'utente (se ordino una volta da un ristorante con cucina "cinese" e due volte da un
 * ristorante con cucina "fast food", la cucina più apprezzata da me è "fast food")
 * * Dato un utente **u**, utilizzando la cucina più apprezzata dall'utente **u**, scegliere un ristorante che ha quel tipo di
 * cucina e dal quale l'utente **u** non ha mai ordinato
 */

@Getter
public class JustDelivery {
    //Lista dei ristoranti
    private List<Ristorante> ristoranti = new ArrayList<>();

    //Lista degli utenti
    private List<Utente> utenti = new ArrayList<>();

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
    /**
     * Metodo per stampare il menú
     */
    public void stampaMenu(Ristorante ristorante) {
        System.out.println("Menu del ristorante " + ristorante.getNome() + ":");
        for (Prodotto prodotto : ristorante.getMenu()) {
            System.out.println(prodotto.toString());
        }
        System.out.println();
    }

    /**
     *Aggiungere prodotto ad un ordine esistente
     * @param prodotto : prodotto da aggiungere
     * @param utente :  utente a cui aggiungere il prodotto all'ordine
     * @param ristorante :  ristrorante da cui proviene l'ordine
     */
    public void addProdotto(Prodotto prodotto, Utente utente, Ristorante ristorante){
        //Cerca l'utente nella lista
        //utente.aggiungiOrdine(prodotto, ristorante)
        ArrayList<Prodotto> prodotti =new ArrayList<>();
        prodotti.add(prodotto);
        addProdotto(prodotti,utente,ristorante);
    }


    /**
     *Aggiungere prodotto ad un ordine esistente
     * @param prodotti : prodotti da aggiungere
     * @param utente :  utente a cui aggiungere i prodotti all'ordine
     * @param ristorante :  ristrorante da cui proviene l'ordine
     */
    public void addProdotto(ArrayList<Prodotto> prodotti, Utente utente, Ristorante ristorante){
        for (Utente ut : utenti) {
            if (ut.equals(utente)) {
                ut.aggiungiOrdine(prodotti,ristorante);
            }
        }

    }

    /**
     * Stampa del dettaglio dell'ordine
     * (lista prodotti, prezzo totale calcolando le spese di consegna)
     * @param ordine
     * @return
     */
    public void stampaOrdine(Ordine ordine){
        ordine.toString();
    }

    /**
     * Ottenere lo storico degli ordini di un utente
     * @param utente : utente di cui bisogna conoscere lo storico degli ordini
     * @return  : storico ordini;
     */
    public ArrayList<Ordine> storicoOrdini(Utente utente){
        return utente.getOrdini();
    }

    public List<Ordine> getStoricoOrdini(Utente utente){
        return utente.getOrdini();
    }

    public List<Ristorante> getRistorantiFromOrdini(Utente utente){
        return utente.getListaRistorantiOrdinati();
    }

    public TipoCucina getCucinaPreferita(Utente utente){
        return utente.getTipoCucinaPreferito();
    }

    public List<Ristorante> getRistoranti() {
        return ristoranti;
    }

    public List<Utente> getUtenti() {
        return utenti;
    }

    public void chiudiOrdine(Utente utente){
        utente.chiudiOrdine();
    }

    public Ristorante getRistoranteMaiOrdinato(Utente utente){
        TipoCucina tipoCucina = utente.getTipoCucinaPreferito();
        List<Ristorante> ristorantiUtente = utente.getListaRistoranti();

        for (Ristorante ristorante : ristoranti) {
            if (ristorante.getTipoCucina().contains(tipoCucina) && !ristorantiUtente.contains(ristorante)){
                return ristorante;
            }
        }
        return null;
    }
}