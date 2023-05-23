public class PrenotazioneSingola extends Prenotazione{

    private Preferenza preferenza;

    public PrenotazioneSingola(String codUnivoco, Preferenza pref) {
        super(codUnivoco, 1);
        this.preferenza = pref;
    }

    public Preferenza getPreferenza() {
        return preferenza;
    }
}
