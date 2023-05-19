public class Tecnico {
    private String nome;

    private boolean ferie = false;

    public boolean isFerie() {
        return ferie;
    }

    public void setFerie(boolean ferie) {
        this.ferie = ferie;
    }

    public Tecnico(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
