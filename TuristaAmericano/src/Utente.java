public class Utente {
    private String nome;
    private String cognome;
    private String email;
    private String indirizzo;

    public Utente(String nome, String cognome, String email, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    @Override
    public boolean equals(Object obj) {
        Utente u2 = (Utente) obj;
        return this.email.equals(u2.email);
    }

    @Override
    public String toString() {
        return "(" + nome + ", " + email + ")";
    }
}
