public class GiocoDellOca {
    private Tabellone tabellone;
    private Giocatore[] giocatori;

    public GiocoDellOca(int n, Giocatore[] giocatori) {
        this.tabellone = new Tabellone(n);
        this.giocatori = giocatori;
    }

    public void giocaUnTurno(){
        for (Giocatore giocatore : giocatori) {
            tabellone.spostaGiocatore(giocatore);
        }
        for (Giocatore giocatore : giocatori) {
            System.out.println(giocatore.getNome() + " è in posizione " + giocatore.getPosizioneAttuale());
        }
    }

}
