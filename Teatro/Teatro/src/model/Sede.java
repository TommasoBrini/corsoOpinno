package model;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@ToString
public class Sede implements Comparable<Sede> {

    private Integer id;
    @NonNull private String nome;
    @NonNull private String indirizzo;
    @NonNull private String comune;
    private boolean isOpen;

    public Sede(@NonNull String nome, @NonNull String indirizzo, @NonNull String comune, boolean isOpen) {
        this(null, nome, indirizzo, comune, isOpen);
    }

    public Sede(Integer id, @NonNull String nome, @NonNull String indirizzo, @NonNull String comune, boolean isOpen) {
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.comune = comune;
        this.isOpen = isOpen;
    }

    @Override
    public int compareTo(Sede sede) {
        return this.id.compareTo(sede.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sede sede = (Sede) obj;
        return id.equals(sede.id);
    }

    public static Sede fromResultSet(ResultSet rs) throws SQLException {
        return new Sede(rs.getInt("id"), rs.getString("nome"), rs.getString("indirizzo"), rs.getString("comune"), rs.getBoolean("isopen"));
    }

}