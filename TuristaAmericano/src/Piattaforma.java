import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Piattaforma {
    private Map<String, Utente> utenti = new HashMap();
    private Map<Integer, Host> hosts = new HashMap();
    private Map<Integer, Abitazione> abitazioni = new HashMap();
    private Map<Integer, AbitazionePrenotabile> abitazioniPrenotabile = new HashMap<>();
    private Set<Prenotazione> prenotazioni = new HashSet<>();
    private Map<Utente, Set<Prenotazione>> prenotazioneUtente = new HashMap<>();

    public void addUtente(Utente utente){
        utenti.put(utente.getEmail(), utente);
    }

    private void addHost(Host host){
        hosts.put(host.getCodHost(), host);
    }

    public void approvaHost(Utente utente, int codHost){
        Host host = new Host(codHost, utente);
        System.out.println("L'utente " + utente + " è diventato host");
        addHost(host);
    }

    public Host getHostById(int codHost){
        return hosts.get(codHost);
    }

    public void addAbitazione(Abitazione abitazione){
        abitazioni.put(abitazione.getIdUnivoco(), abitazione);
    }

    public void pubblicaAbitazione(Abitazione abitazione, double prezzo, LocalDate dataInizio, LocalDate dataFine){
        AbitazionePrenotabile abitazionePrenotabile = new AbitazionePrenotabile(abitazione, prezzo, dataInizio, dataFine);
        abitazioniPrenotabile.put(abitazionePrenotabile.getIdUnivoco(), abitazionePrenotabile);
    }

    public AbitazionePrenotabile getAbitazionePrenotabile(int codAbitazione){
        return abitazioniPrenotabile.get(codAbitazione);
    }

    public Map<Integer, AbitazionePrenotabile> getAbitazioniPrenotabili(){
        return abitazioniPrenotabile;
    }

    public Map<Integer, Abitazione> getAbitazioni() {
        return abitazioni;
    }

    public void addPrenotazione(Prenotazione prenotazione){
        prenotazioni.add(prenotazione);
    }

    public Map<String, Utente> getUtenti() {
        return utenti;
    }

    /**
     * ottenere le abitazioni corrispondente ad un certo codice host
     * @param codiceHost
     * @return
     */
    public Set<Abitazione> getAbitazione(int codiceHost){
        Set<Abitazione> res = new HashSet<>();
        for (Map.Entry abitazione : abitazioni.entrySet()){
            Abitazione ab = (Abitazione) abitazione.getValue();

            if(ab.getHost().getCodHost() == codiceHost){
               res.add(ab);
            }
        }

        return res;
    }

    //* - ottenere l'ultima prenotazione dato un id utente
    public Prenotazione lastPrenotazione(String email) {
        Prenotazione risultato = null;
        Utente utente = utenti.get(email);
        for (Prenotazione prenotazione : prenotazioni) {
            if (prenotazione.getUtente().equals(utente)) {
                if (risultato == null || prenotazione.getDataFine().isAfter(risultato.getDataFine())) {
                    risultato = prenotazione;
                }
            }
        }
        return risultato;
    }



    /**
     * ottenere i 5 utenti con più giorni prenotati nell'ultimo mese
     * @return Set<Utente>
     */
    public Set<Utente> maxUtentePrenotazioni(){
        LocalDateTime date = LocalDateTime.parse("");
        date.getMonth();
        return null;
    }


    /**
     * ottenere il numero medio di posti letto calcolato in base a tutte le abitazioni caricate dagli host
     *
     * @return
     */
    public int mediaPostiLetto(){
        int count = 0;
        for (Map.Entry abitazione : abitazioni.entrySet()){
            count += ((Abitazione) abitazione.getValue()).getNumPosti();
        }
        try{
            count = count/abitazioni.size();
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return count;
    }

}
