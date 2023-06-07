import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Ristorante {
    private String nome;
    private UUID id;
    private List<Prodotto> menu = new ArrayList();
    private List<TipoCucina> tipoCucina = new ArrayList();
    private double spesaSpedizione;

    public Ristorante(String nome,UUID id, List<TipoCucina> tipoCucina, double spesaSpedizione) {
        this.nome=nome;
        this.id = id;
        this.tipoCucina = tipoCucina;
        this.spesaSpedizione = spesaSpedizione;
    }

    public String getNome() {
        return nome;
    }

    public UUID getId() {
        return id;
    }

    public List<Prodotto> getMenu() {
        return menu;
    }

    public List<TipoCucina> getTipoCucina() {
        return tipoCucina;
    }

    public void setMenu(List<Prodotto> menu) {
        this.menu = menu;
    }

    public double getSpesaSpedizione(){
        return spesaSpedizione;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ristorante other = (Ristorante) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "nome = " + nome;
    }

}