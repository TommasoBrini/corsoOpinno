import lombok.Getter;
import lombok.NonNull;

import java.util.*;

@Getter
public class Utente {
    String nome;
    @NonNull
    UUID id;
    ArrayList<Ordine> ordini;
    Ordine ordineCorrente;

    public Utente(String nome,@NonNull UUID id) {
        this.nome = nome;
        this.id = id;
        ordini= new ArrayList<>();
    }

    /**
     * Aggiunge prodotti, se è già presente aggiunge i vari prodotti
     * @return
     */
    public void aggiungiOrdine(ArrayList<Prodotto> prodotti,Ristorante ristorante){
        if(ordineCorrente==null) {
            ordineCorrente = new Ordine(prodotti, ristorante);
        }else{
            try {
                if(ristorante==ordineCorrente.getRistorante()) {
                    ordineCorrente.aggiungiProdotti(prodotti);
                }else{
                    throw new RistoranteNotEquals();
                }
            }catch(RistoranteNotEquals e){
                System.out.println("Ristorante diverso");
            }
        }
    }

    /**
     * Inserisce l'ordine nello storico ordini e ti restituisce l'ordine completo
     * @return
     */
    public Ordine  chiudiOrdine(){
        Ordine ordineConcluso=new Ordine(ordineCorrente.getProdotti(),ordineCorrente.getRistorante());
        ordineCorrente=null;
        ordini.add(ordineConcluso);
        return ordineConcluso;
    }


    /**
     * Restituisce gli ordini di un utente
     * @return
     */
    public ArrayList<Ordine> getOrdini() {
        return ordini;
    }


    /**
     * Restituisce l'ordine corrente
     * @return
     */
    public Ordine getOrdineCorrente() {
        return ordineCorrente;
    }

    /**
     * Restituisce una lista di ristoranti dove l'utente ha mangiato almeno una volta
     * @return
     */
    public ArrayList<Ristorante> getListaRistoranti(){
        ArrayList<Ristorante> ristoranti=new ArrayList<>();

        for(Ordine ordine:ordini){
            if(!ristoranti.contains(ordine.getRistorante())){
                ristoranti.add(ordine.getRistorante());
            }
        }

        return ristoranti;
    }

    /**
     * Restituisce il TipoCucina preferito dall'utente in base a quali ristoranti ha ordinato
     * @return
     */
    public TipoCucina getTipoCucinaPreferito(){
        Map<TipoCucina,Integer> check= new HashMap<>();
        for(Ordine ordine:ordini){
            for(TipoCucina tipoCucina:ordine.getRistorante().getTipoCucina()) {
                if (check.get(tipoCucina) == null) {
                    check.put(tipoCucina, 1);
                } else {
                    check.put(tipoCucina,(check.get(tipoCucina) + 1));
                }
            }
        }
        int max=0;
        TipoCucina result=null;
        for(TipoCucina tipoCucina:check.keySet()){
            if(check.get(tipoCucina)>max){
                max=check.get(tipoCucina);
                result=tipoCucina;
            }
        }
        return result;
    }

    /**
     * Restituisce in ordine decrescente i ristoranti in cui l'utente ha mangiato più volte
     * @return
     */
    public List<Ristorante> getListaRistorantiOrdinati(){
        ArrayList<Ristorante> ristoranti=new ArrayList<>();
        Map<Ristorante,Integer> check= new HashMap<>();

        for(Ordine ordine:ordini){
            if(check.get(ordine.getRistorante()) == null){
                check.put(ordine.getRistorante(),1);
            }else{
                check.put(ordine.getRistorante(),(check.get(ordine.getRistorante())+1));
            }
        }
        int max;
        Ristorante ristorantemax=null;

        do {
            max=0;
            for (Ristorante ristorante : check.keySet()) {
                if(check.get(ristorante)>max){
                    max=check.get(ristorante);
                    ristorantemax=ristorante;
                }
            }
            if(max!=0){
                ristoranti.add(ristorantemax);
                check.remove(ristorantemax);
            }
        }while (max!=0);

        return ristoranti;

    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", ordini=" + ordini +
                ", ordineCorrente=" + ordineCorrente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(nome, utente.nome) && Objects.equals(id, utente.id) && Objects.equals(ordini, utente.ordini) && Objects.equals(ordineCorrente, utente.ordineCorrente);
    }
}