package model;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@ToString
public class Posto implements Comparable<Posto>{

    private Integer id;
    @NonNull private int fila;
    @NonNull private int numero;
    @NonNull private int id_sala;

    public Posto(@NonNull int fila, @NonNull int numero, @NonNull int id_sala) {
        this(null, fila, numero, id_sala);
    }

    public Posto(Integer id, @NonNull int fila, @NonNull int numero, @NonNull int id_sala) {
        this.id = id;
        this.fila = fila;
        this.numero = numero;
        this.id_sala = id_sala;
    }

    @Override
    public int compareTo(Posto posto) {
        return this.id.compareTo(posto.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Posto posto = (Posto) obj;
        return id.equals(posto.id);
    }

    public static Posto fromResultSet(ResultSet rs) throws SQLException{
        return new Posto(rs.getInt("id"), rs.getInt("fila"), rs.getInt("numero"), rs.getInt("id_sala"));
    }
}
