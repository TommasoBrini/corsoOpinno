package model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class Ticket implements Comparable<Ticket>{
    private Integer id;
    private Timestamp timestamp;
    @NonNull private int id_utente;
    @NonNull private int id_posto;
    @NonNull private int id_spettacolo;

    public Ticket(@NonNull int id_utente, @NonNull int id_posto, @NonNull int id_spettacolo) {
        this(null, null, id_utente, id_posto, id_spettacolo);
    }

    public Ticket(Integer id, Timestamp timestamp, @NonNull int id_utente, @NonNull int id_posto, @NonNull int id_spettacolo) {
        this.id = id;
        this.timestamp = timestamp;
        this.id_utente = id_utente;
        this.id_posto = id_posto;
        this.id_spettacolo = id_spettacolo;
    }

    @Override
    public int compareTo(Ticket ticket) {
        return this.id.compareTo(ticket.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ticket ticket = (Ticket) obj;
        return id.equals(ticket.id);
    }

    public static Ticket fromResultSet(ResultSet rs) throws SQLException {
        return new Ticket(rs.getInt("id"), rs.getTimestamp("timestamp"), rs.getInt("id_utente"), rs.getInt("id_posto"), rs.getInt("id_spettacolo"));
    }
}
