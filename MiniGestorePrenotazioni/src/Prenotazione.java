public class Prenotazione {
    private String codUnivoco;
    private int nPosti;

    public Prenotazione(String codUnivoco, int nPosti) {
        this.codUnivoco = codUnivoco;
        this.nPosti = nPosti;
    }

    public String getCodUnivoco() {
        return codUnivoco;
    }

    public int getnPosti() {
        return nPosti;
    }
}
