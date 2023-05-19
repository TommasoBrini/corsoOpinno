package lampadina;

public class Lampadina {
    private Stato stato;
    private int count;

    Impianto impianto;

    public Lampadina(Impianto impianto){
        this.stato = Stato.SPENTA;
        count = 10;
        this.impianto = impianto;
    }

    public Stato statoLampadina(){
        if(!impianto.isStato()){
            if(stato != stato.ROTTA) {
                stato = Stato.SPENTA;
            }
        }
        return stato;
    }

    public void click(){
        if(count > 0){
            if(stato == Stato.ACCESA){
                stato = Stato.SPENTA;
                count--;
                //System.out.println("La lampadina è stata spenta");
            } else {
                stato = Stato.ACCESA;
                count--;
                //System.out.println("La lampadina è stata accesa");
            }
        } else {
            stato = Stato.ROTTA;
            System.out.println("La lampadina si è rotta");
        }
    }
}
