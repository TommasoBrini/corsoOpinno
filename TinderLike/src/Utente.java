import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utente {
    private String nome;
    private Set<Interesse> interessi = new HashSet<>();

    public Utente(String nome) {
        this.nome = nome;
    }

    public void addInteresse(Interesse interesse){
        interessi.add(interesse);
    }

    public void removeInteresse(Interesse interesse){
        interessi.remove(interesse);
    }

    public String getNome() {
        return nome;
    }

    public Set<Interesse> getInteressi() {
        return interessi;
    }

    @Override
    public String toString() {
        return "nome='" + nome;
    }
}
