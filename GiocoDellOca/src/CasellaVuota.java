public class CasellaVuota extends Casella{
    public CasellaVuota(int id) {
        super(id);
    }

    @Override
    public void effettoCasella(Giocatore giocatore) {
        System.out.println("SEI CAPITATO IN UNA CASELLA VUOTA!");
    }

    @Override
    public String toString() {
        return "CasellaVuota{}";
    }
}
