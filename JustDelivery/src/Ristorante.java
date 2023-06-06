import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Ristorante {
    private UUID id;
    private List<Prodotto> menu = new ArrayList();
    private List<TipoCucina> tipoCucina = new ArrayList();

    public Ristorante(UUID id, List<TipoCucina> tipoCucina) {
        this.id = id;
        this.menu = menu;
        this.tipoCucina = tipoCucina;
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

}
