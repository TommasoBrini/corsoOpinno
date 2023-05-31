public class Abitazione {
    private int idUnivoco;
    private String nome;
    private String indirizzo;
    private int numLocali;
    private int numPosti;
    private int piano;
    private Host host;

    public Abitazione(int idUnivoco, String nome, String indirizzo, int numLocali, int numPosti, int piano, Host host) {
        this.idUnivoco = idUnivoco;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.numLocali = numLocali;
        this.numPosti = numPosti;
        this.piano = piano;
        this.host = host;
    }

    public int getIdUnivoco() {
        return idUnivoco;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public int getNumLocali() {
        return numLocali;
    }

    public int getNumPosti() {
        return numPosti;
    }

    public int getPiano() {
        return piano;
    }

    public Host getHost() {
        return host;
    }

    @Override
    public String toString() {
        return "Abitazione{" +
                "idUnivoco=" + idUnivoco +
                ", nome='" + nome + '\'' +
                ", host=" + host +
                '}';
    }
}
