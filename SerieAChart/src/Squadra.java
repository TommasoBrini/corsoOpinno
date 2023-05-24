public class Squadra {

    private int id;
    private String nome;
    private Giocatore[] rosa;
    private int punteggio;
    private int golFatti;
    private int golSubiti;

    public Squadra(int id, String nome, Giocatore[] rosa) {
        this.id = id;
        this.nome = nome;
        this.rosa = rosa;
        this.punteggio = 0;
        this.golFatti = 0;
        this.golSubiti = 0;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Giocatore[] getRosa() {
        return rosa;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public int getGolFatti() {
        return golFatti;
    }

    public int getGolSubiti() {
        return golSubiti;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public void setGolFatti(int golFatti) {
        this.golFatti = golFatti;
    }

    public void setGolSubiti(int golSubiti) {
        this.golSubiti = golSubiti;
    }

    @Override
    public String toString() {
        return "Squadra{" +
                "nome=" + nome + ", " +
                "punti=" + punteggio +
                '}';
    }
}
