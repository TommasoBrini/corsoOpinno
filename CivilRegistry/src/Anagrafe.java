import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Anagrafe {
    List<Persona> persone = new ArrayList<>();

    public void addPersona(Persona persona){
        persone.add(persona);
    }

    public void removePersona(String CF){
        persone.removeIf(p -> p.getCF().equals(CF));
    }

    public List<Persona> getPersona(String nome){
        return persone.stream()
                .filter(p -> p.getNome().startsWith(nome))
                .collect(Collectors.toList());
    }

    public List<Persona> getPersoneAnziane(){
        return persone.stream()
                .sorted(Comparator.comparing(Persona::getEta).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public List<String> getIndirizzi(String nome){
        return persone.stream()
                .filter(p -> p.getNome().equals(nome))
                .map(Persona::getIndirizzo)
                .collect(Collectors.toList());
    }
    
}
