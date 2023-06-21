package DAO.implement;

import DAO.dao.PostoDAO;
import connection_handler.ConnectionHandler;
import model.Posto;
import model.Spettacolo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostoDaoSQL implements PostoDAO {

    @Override
    public boolean insert(Posto p) throws SQLException {
        String query = "INSERT INTO teatro.posto (fila, numero, id_sala) VALUES (?,?,?)";

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        ps.setInt(1, p.getFila());
        ps.setInt(2, p.getNumero());
        ps.setInt(3, p.getId_sala());

        int insertedCount = ps.executeUpdate();

        return insertedCount > 0;
    }

    @Override
    public boolean update(Posto p) throws SQLException {
        String query = "UPDATE teatro.posto SET fila = ?, numero = ?, id_sala = ? WHERE id = ?";

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        ps.setInt(1, p.getFila());
        ps.setInt(2, p.getNumero());
        ps.setInt(3, p.getId_sala());
        ps.setInt(4, p.getId());

        int updateCount = ps.executeUpdate();

        return updateCount > 0;
    }

    @Override
    public boolean delete(Posto elem) throws SQLException {
        String query = "DELETE FROM teatro.posto WHERE id = ?;";

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, elem.getId());
        int deletedCount = ps.executeUpdate();
        return deletedCount > 0;
    }

    @Override
    public Optional<Posto> getById(int id) throws SQLException {
        String query = "SELECT * FROM teatro.posto WHERE id = ?";

        Optional<Posto> posto = Optional.empty();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) posto = Optional.of(Posto.fromResultSet(rs));
        return posto;
    }

    @Override
    public List<Posto> getAll() throws SQLException {
        String query = "SELECT * FROM teatro.posto";

        List<Posto> posti = new ArrayList<>();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) posti.add(Posto.fromResultSet(rs));

        return posti;
    }


    @Override
    public List<Posto> getPostoDisponibileBySpettacolo(Spettacolo spettacolo) throws SQLException {

        String query = "SELECT posto.* FROM posto " +
                "LEFT JOIN spettacolo ON posto.id_sala = spettacolo.id_sala " +
                "WHERE spettacolo.id = ? and posto.id in " +
                "(SELECT posto.id FROM posto " +
                "LEFT JOIN ticket ON posto.id = ticket.id_posto WHERE ticket.id_posto is null)";


        List<Posto> posti = new ArrayList<>();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);
        ps.setInt(1, spettacolo.getId());
        ResultSet rs = ps.executeQuery();

        while (rs.next()) posti.add(Posto.fromResultSet(rs));

        return posti;
    }
}
