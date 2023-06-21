package model;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@ToString
public class Utente implements Comparable<Utente>{

    private Integer id;
    @NonNull
    private String nome;
    @NonNull
    private String cognome;
    @NonNull
    private String email;
    @NonNull
    private String telefono;
    @NonNull
    private String indirizzo;

    public Utente(@NonNull String nome, @NonNull String cognome, @NonNull String email, @NonNull String telefono, @NonNull String indirizzo) {
        this(null,nome,cognome,email,telefono,indirizzo);
    }

    public Utente(Integer id, @NonNull String nome, @NonNull String cognome, @NonNull String email, @NonNull String telefono, @NonNull String indirizzo) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
    }

    @Override
    public int compareTo(Utente utente) {
        return this.id.compareTo(utente.id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Utente utente= (Utente) obj;
        return id.equals(utente.id);
    }

    public static Utente fromResultSet (ResultSet rs) throws SQLException {
        return new Utente((rs.getInt("id")),
                rs.getString("nome"),
                rs.getString("cognome"),
                rs.getString("email"),
                rs.getString("telefono"),
                rs.getString("indirizzo"));
    }
}
