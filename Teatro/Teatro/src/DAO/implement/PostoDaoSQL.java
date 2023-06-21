package DAO.implement;

import DAO.dao.PostoDAO;
import connection_handler.ConnectionHandler;
import model.Posto;
import model.Spettacolo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PostoDaoSQL implements PostoDAO {

    @Override
    public boolean insert(Posto p) throws SQLException {
        String query = "INSERT INTO posto (fila, numero, id_sala) VALUES (?,?,?)";

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps =  connectionHandler.getPreparedStatement(query);

        ps.setInt(1, p.getFila());
        ps.setInt(2,p.getNumero());
        ps.setInt(2,p.getId_sala());

        int insertedCount = ps.executeUpdate();

        return insertedCount > 0;
    }

    @Override
    public boolean update(Posto elem) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Posto elem) throws SQLException {
        return false;
    }

    @Override
    public Optional<Posto> getById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Posto> getAll() throws SQLException {
        return null;
    }


    @Override
    public List<Posto> getPostoDisponibileBySpettacolo(Spettacolo spettacolo) throws SQLException {
        return null;
    }
}
