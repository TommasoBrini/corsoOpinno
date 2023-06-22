package model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
public class Spettacolo implements Comparable<Spettacolo>{
    private Integer id;
    @NonNull private String nome;
    @NonNull private LocalTime orario;
    @NonNull private int durata;
    @NonNull private String genere;
    @NonNull private double prezzo;
    @NonNull private int id_sala;

    public Spettacolo(@NonNull String nome, @NonNull LocalTime orario, @NonNull int durata, @NonNull String genere, @NonNull double prezzo, @NonNull int id_sala){
        this(null, nome, orario, durata, genere, prezzo, id_sala);
    }

    public Spettacolo(Integer id, @NonNull String nome, @NonNull LocalTime orario, @NonNull int durata, @NonNull String genere, @NonNull double prezzo, @NonNull int id_sala) {
        this.id = id;
        this.nome = nome;
        this.orario = orario;
        this.durata = durata;
        this.genere = genere;
        this.prezzo = prezzo;
        this.id_sala = id_sala;
    }

    @Override
    public int compareTo(Spettacolo spettacolo) {
        return this.id.compareTo(spettacolo.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Spettacolo spettacolo = (Spettacolo) obj;
        return id.equals(spettacolo.id);
    }

    public static Spettacolo fromResultSet(ResultSet rs) throws SQLException {
        return new Spettacolo(rs.getInt("id"), rs.getString("nome"), rs.getTime("orario").toLocalTime(), rs.getInt("durata"), rs.getString("genere"), rs.getInt("prezzo"), rs.getInt("id_sala"));
    }
}
