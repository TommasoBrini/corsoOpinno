package DAO.implement;



import DAO.dao.SalaDAO;
import connection_handler.ConnectionHandler;
import model.Sala;
import model.Sede;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SalaDaoSQL implements SalaDAO {

    @Override
    public boolean insert(Sala s) throws SQLException {
        String query = "INSERT INTO teatro.sala (nome, id_sede) VALUES (?,?)";

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        ps.setString(1, s.getNome());
        ps.setInt(2, s.getId_sede());

        int insertedCount = ps.executeUpdate();

        return insertedCount > 0;
    }

    @Override
    public boolean update(Sala s) throws SQLException {
        String query = "UPDATE teatro.sala SET nome = ?, id_sede = ? WHERE id = ?";

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        ps.setString(1, s.getNome());
        ps.setInt(2, s.getId_sede());
        ps.setInt(3, s.getId());

        int updateCount = ps.executeUpdate();

        return updateCount > 0;
    }

    @Override
    public boolean delete(Sala elem) throws SQLException {
        String query = "DELETE FROM teatro.sala WHERE id = ?;";

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, elem.getId());
        int deletedCount = ps.executeUpdate();
        return deletedCount > 0;
    }

    @Override
    public Optional<Sala> getById(int id) throws SQLException {
        String query = "SELECT * FROM teatro.sala WHERE id = ?";

        Optional<Sala> sala = Optional.empty();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) sala = Optional.of(Sala.fromResultSet(rs));
        return sala;
    }

    @Override
    public List<Sala> getAll() throws SQLException {
        String query = "SELECT * FROM teatro.sala";

        List<Sala> sale = new ArrayList<>();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) sale.add(Sala.fromResultSet(rs));

        return sale;
    }


    @Override
    public List<Sala> getSalaBySede(int sede) throws SQLException {

        String query = "Select * " +
                "FROM teatro.sala " +
                "WHERE id_sede = ?";

        List<Sala> sale = new ArrayList<>();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);
        ps.setInt(1, sede);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) sale.add(Sala.fromResultSet(rs));

        return sale;
    }
}