public class Prodotto {
    private String nome;
    private double prezzo;

    public Prodotto(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public void setNome(String name) {this.nome = name;}

    public void setPrezzo(double prezzo) {this.prezzo = prezzo;}

    public String getNome() {return nome;}

    public double getPrezzo() {return prezzo;}
}
