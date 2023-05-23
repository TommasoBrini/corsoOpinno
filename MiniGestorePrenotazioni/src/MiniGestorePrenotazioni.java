public class MiniGestorePrenotazioni {
    //POSTI ALL'INTERNO
    private int m;
    //POSTI ALL'ESTERNO
    private int n;

    private Prenotazione[] prenotazioniAttualiInterno;

    private Prenotazione[] prenotazioniAttualiEsterno;

    public MiniGestorePrenotazioni(int m, int n) {
        this.m = m;
        this.n = n;
        prenotazioniAttualiInterno = new Prenotazione[m];
        prenotazioniAttualiEsterno = new Prenotazione[n];
    }

    //data una Prenotazione p in input, se c’è posto nel ristorante viene accettata restituendo true
    // (dando precedenza alla preferenza indicata), altrimenti viene rifiutata restituendo false
    public boolean prenota(Prenotazione p){
        if(p.getClass() == PrenotazioneSingola.class){
            PrenotazioneSingola ps = (PrenotazioneSingola) p;
            if(ps.getPreferenza() == Preferenza.ESTERNO){
                if(n > 0){
                    prenotazioniAttualiEsterno[prenotazioniAttualiEsterno.length - n] = p;
                    n--;
                    return true;
                } else if(m > 0){
                    prenotazioniAttualiInterno[prenotazioniAttualiInterno.length - m] = p;
                    m--;
                    return true;
                }
            } else if(ps.getPreferenza() == Preferenza.INTERNO){
                if(m > 0){
                    prenotazioniAttualiInterno[prenotazioniAttualiInterno.length - m] = p;
                    m--;
                    return true;
                } else if(n > 0){
                    prenotazioniAttualiEsterno[prenotazioniAttualiEsterno.length - n] = p;
                    n--;
                    return true;
                }
            }
        } else {
            if(p.getnPosti() <= m){
                prenotazioniAttualiInterno[prenotazioniAttualiInterno.length - m] = p;
                m = m - p.getnPosti();
                return true;
            } else if(p.getnPosti() <= n){
                prenotazioniAttualiEsterno[prenotazioniAttualiEsterno.length - n] = p;
                n = n - p.getnPosti();
                return true;
            }
        }
        return false;
    }


    //data una Prenotazione p in input, termina la prenotazione eliminandola e liberando i posti associati.
    public void terminaPrenotazione(Prenotazione p){
        int i = 0;
        for (Prenotazione prenotazione : prenotazioniAttualiInterno) {
            if(prenotazione != null && prenotazione.getCodUnivoco().equals(p.getCodUnivoco())){
                prenotazioniAttualiInterno[i] = null;
                m = m + prenotazione.getnPosti();
                i++;
            }
        }
        i = 0;
        for(Prenotazione prenotazione : prenotazioniAttualiEsterno){
            if(prenotazione != null && prenotazione.getCodUnivoco().equals(p.getCodUnivoco())){
                prenotazioniAttualiEsterno[i] = null;
                n = n + prenotazione.getnPosti();
                i++;
            }
        }

    }
    public Prenotazione[] prenotazioniAttualiEsterno(){
        return prenotazioniAttualiEsterno;
    } //ritorna un array con le attuali prenotazioni per l’esterno del ristorante

    public Prenotazione[] prenotazioniAttualiInterno(){
        return prenotazioniAttualiInterno;
    } //ritorna un array con le attuali prenotazioni per l’interno del ristorante
}
