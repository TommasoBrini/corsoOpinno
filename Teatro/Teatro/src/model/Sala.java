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
public class Sala implements Comparable<Sala>{

    private Integer id;
    @NonNull
    private String nome;
    @NonNull
    private int id_sede;

    public Sala(@NonNull String nome, @NonNull int id_sede) {
        this(null,nome,id_sede);
    }

    public Sala(Integer id, @NonNull String nome, @NonNull int id_sede) {
        this.id = id;
        this.nome = nome;
        this.id_sede = id_sede;
    }

    @Override
    public int compareTo(Sala sala) {
        return this.id.compareTo(sala.id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Sala sala= (Sala) obj;
        return id.equals(sala.id);
    }

    public static Sala fromResultSet (ResultSet rs) throws SQLException {
        return new Sala((rs.getInt("id")),
                rs.getString("nome"),
                rs.getInt("id_sede"));
    }
}
