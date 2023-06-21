package DAO.implement;

import DAO.dao.TicketDAO;
import connection_handler.ConnectionHandler;
import model.Posto;
import model.Spettacolo;
import model.Ticket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDaoSQL implements TicketDAO {
    @Override
    public boolean insert(Ticket t) throws SQLException {
        String query = "INSERT INTO teatro.ticket (timestamp, id_utente, id_posto, id_spettacolo) VALUES (?,?,?,?)";

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        Timestamp tm = new Timestamp(System.currentTimeMillis());
        ps.setTimestamp(1, tm);
        ps.setInt(2, t.getId_utente());
        ps.setInt(3, t.getId_posto());
        ps.setInt(4, t.getId_spettacolo());

        int insertedCount = ps.executeUpdate();

        return insertedCount > 0;
    }

    @Override
    public boolean update(Ticket elem) throws SQLException {
        String query = "UPDATE teatro.ticket SET id_utente = ?, id_posto = ?, id_spettacolo = ? WHERE id = ?";

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        ps.setInt(1, elem.getId_utente());
        ps.setInt(2, elem.getId_posto());
        ps.setInt(3, elem.getId_spettacolo());
        ps.setInt(4, elem.getId());

        int updateCount = ps.executeUpdate();

        return updateCount > 0;
    }

    @Override
    public boolean delete(Ticket elem) throws SQLException {
        String query = "DELETE FROM teatro.ticket WHERE id = ?;";

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, elem.getId());
        int deletedCount = ps.executeUpdate();
        return deletedCount > 0;
    }

    @Override
    public Optional<Ticket> getById(int id) throws SQLException {
        String query = "SELECT * FROM teatro.ticket WHERE id = ?";

        Optional<Ticket> ticket = Optional.empty();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) ticket = Optional.of(Ticket.fromResultSet(rs));
        return ticket;
    }

    @Override
    public List<Ticket> getAll() throws SQLException {
        String query = "SELECT * FROM teatro.ticket";

        List<Ticket> tickets = new ArrayList<>();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) tickets.add(Ticket.fromResultSet(rs));

        return tickets;
    }

    @Override
    public int getBigliettiVenduti(Spettacolo spettacolo) throws SQLException {
        String query = "SELECT COUNT(*) FROM teatro.ticket WHERE id_spettacolo = ?";
        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, spettacolo.getId());

        int n = 0;
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                n = rs.getInt(1);
            }
        }

        return n;

    }
}
