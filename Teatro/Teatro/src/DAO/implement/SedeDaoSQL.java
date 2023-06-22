package DAO.implement;

import DAO.dao.SedeDAO;
import connection_handler.ConnectionHandler;
import model.Sede;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SedeDaoSQL implements SedeDAO {

    @Override
    public boolean insert(Sede s) throws SQLException {
        String query = "INSERT INTO teatro.sede (nome, indirizzo, comune, isopen) VALUES (?,?,?,?)";

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        ps.setString(1, s.getNome());
        ps.setString(2, s.getIndirizzo());
        ps.setString(3, s.getComune());
        ps.setBoolean(4, s.isOpen());

        int insertedCount = ps.executeUpdate();

        return insertedCount > 0;
    }

    @Override
    public boolean update(Sede s) throws SQLException {
        String query = "UPDATE teatro.sede SET nome = ?, indirizzo = ?, comune = ?, isopen = ? WHERE id = ?";

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        ps.setString(1, s.getNome());
        ps.setString(2, s.getIndirizzo());
        ps.setString(3, s.getComune());
        ps.setBoolean(4, s.isOpen());
        ps.setInt(5, s.getId());

        int updateCount = ps.executeUpdate();

        return updateCount > 0;
    }

    @Override
    public boolean delete(Sede elem) throws SQLException {
        String query = "DELETE FROM teatro.sede WHERE id = ?;";

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, elem.getId());
        int deletedCount = ps.executeUpdate();
        return deletedCount > 0;
    }

    @Override
    public Optional<Sede> getById(int id) throws SQLException {
        String query = "SELECT * FROM teatro.sede WHERE id = ?";

        Optional<Sede> sede = Optional.empty();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) sede = Optional.of(Sede.fromResultSet(rs));
        return sede;
    }

    @Override
    public List<Sede> getAll() throws SQLException {
        String query = "SELECT * FROM teatro.sede";

        List<Sede> sedi = new ArrayList<>();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) sedi.add(Sede.fromResultSet(rs));

        return sedi;
    }

    @Override
    public List<Sede> getSedeIsOpen() throws SQLException {
        String query = "SELECT * FROM teatro.sede WHERE isopen = true";

        List<Sede> sedi = new ArrayList<>();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) sedi.add(Sede.fromResultSet(rs));

        return sedi;
    }
}