public class Giocatore {
    private String nome;
    private int posizioneAttuale;
    private int punteggio;

    public Giocatore(String nome) {
        this.nome = nome;
        posizioneAttuale = 0;
        punteggio = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPosizioneAttuale() {
        return posizioneAttuale;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPosizioneAttuale(int posizioneAttuale) {
        this.posizioneAttuale = posizioneAttuale;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }
}
