import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

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

    /**
     * ottenere l'ultima prenotazione dato un id utente
     * @param email
     * @return
     */
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
     * ottenere l'abitazione più gettonata nel mese Date
     * @param date
     * @return
     */
    public Abitazione abitazioneGettonata(LocalDate date){
        Abitazione risultato=null;
        int max=0;
        date.minusMonths(1);
        Map<Abitazione,Integer> check=new HashMap<>();

        //conto quante prenotazioni sono state fatte nell'ultimo mese
        for(Prenotazione prenotazione:prenotazioni){
            if(date.isAfter(prenotazione.getDataFine())) {
                if (check.get(prenotazione.getAbitazione()) == null) {
                    check.put(prenotazione.getAbitazione(), 1);
                }else {
                    check.put(prenotazione.getAbitazione(), (check.get(prenotazione.getAbitazione()) + 1));
                }
            }
        }
        //cerco quale abitazione ha più prenotazioni e la inserisco nel risultato
        for(Abitazione abitazione:check.keySet()){
            if(check.get(abitazione)>max){
                risultato=abitazione;
                max=check.get(abitazione);
            }
        }
        return risultato;
    }

    public void rendiSuperHost(int codHost){
        hosts.get(codHost).setNumPrenotazioni(110);
    }

    /**
     * ottenere l'abitazione più gettonata nell'ultimo mese
     * @return
     */
    public Abitazione abitazioneGettonata(){
        Abitazione risultato=null;
        int max=0;
        LocalDate date= LocalDate.now();
        date.minusMonths(1);
        Map<Abitazione,Integer> check=new HashMap<>();

        //conto quante prenotazioni sono state fatte nell'ultimo mese
        for(Prenotazione prenotazione:prenotazioni){
            if(date.isAfter(prenotazione.getDataFine())) {
                if (check.get(prenotazione.getAbitazione()) == null) {
                    check.put(prenotazione.getAbitazione(), 1);
                }else {
                    check.put(prenotazione.getAbitazione(), (check.get(prenotazione.getAbitazione()) + 1));
                }
            }
        }
        //cerco quale abitazione ha più prenotazioni e la inserisco nel risultato
        for(Abitazione abitazione:check.keySet()){
            if(check.get(abitazione)>max){
                risultato=abitazione;
                max=check.get(abitazione);
            }
        }
        return risultato;
    }

    /**
     * ottenere gli host con più prenotazioni nell'ultimo mese
     * @return
     */
    public Host hostGettonato(){
        Host risultato=null;
        int max=0;
        LocalDate date= LocalDate.now();
        date.minusMonths(1);
        Map<Host,Integer> check=new HashMap<>();

        for (Prenotazione prenotazione:prenotazioni){
            if(date.isAfter(prenotazione.getDataFine())){
                if(check.get(prenotazione.getUtente())==null){
                    check.put(prenotazione.getAbitazione().getHost(), 1);
                }else{
                    check.put(prenotazione.getAbitazione().getHost(),(check.get(prenotazione.getAbitazione().getHost())+1) );
                }

            }
        }
        for(Host host: check.keySet()){
            if(check.get(host)>max){
                risultato=host;
                max=check.get(host);
            }

        }
        return risultato;
    }

    /**
     * ottenere gli host con più prenotazioni nell'ultimo mese
     * @param date
     * @return
     */
    public Host hostGettonato(LocalDate date ){
        Host risultato=null;
        int max=0;
        date.minusMonths(1);
        Map<Host,Integer> check=new HashMap<>();

        for (Prenotazione prenotazione:prenotazioni){
            if(date.isAfter(prenotazione.getDataFine())){
                if(check.get(prenotazione.getAbitazione().getHost())==null){
                    check.put(prenotazione.getAbitazione().getHost(), 1);
                }else{
                    check.put(prenotazione.getAbitazione().getHost(),(check.get(prenotazione.getAbitazione().getHost())+1) );
                }

            }
        }

        for(Host host: check.keySet()){
            if(check.get(host)>max){
                risultato=host;
                max=check.get(host);
            }

        }

        return risultato;
    }

    /**
     * ottenere tutti i super-host
     * @return
     */
    public Map<Integer,Host> getSuperHost() {
        Map<Integer,Host> risultato=new HashMap<>();
        for(Integer check:hosts.keySet()){
            if(hosts.get(check).getNumPrenotazioni()>=100){
                risultato.put(check,hosts.get(check));
            }
        }
        return risultato;
    }


    /**
     * ottenere i 5 utenti con più giorni prenotati nell'ultimo mese
     */
    public void getTopUtenti(){
        Map<Utente,Integer> check= new HashMap<>();

        for(Prenotazione prenotazione:prenotazioni){
            int  giorni=(int) DAYS.between(prenotazione.getDataInizio(), prenotazione.getDataFine());
            if(check.get(prenotazione.getUtente())==null){
                check.put(prenotazione.getUtente(),giorni);
            }else{
                check.put(prenotazione.getUtente(),(check.get(prenotazione.getUtente())+giorni) );
            }
        }

        int max;
        Utente base;
        for(int i=0;i<5;i++){
            max=0;
            base=null;
            for(Utente utente:check.keySet()){
                if(check.get(utente)>=max){
                    max=check.get(utente);
                    base=utente;
                }
            }
            System.out.println((i+1)+" "+base+" "+max);
            check.remove(base);
        }

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
