package DAO.implement;

import connection_handler.ConnectionHandler;
import DAO.dao.SpettacoloDAO;
import model.Posto;
import model.Spettacolo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpettacoloDaoSQL implements SpettacoloDAO {
    @Override
    public boolean insert(Spettacolo spett) throws SQLException {
        String query = "INSERT INTO teatro.spettacolo (nome, orario, durata, genere, prezzo, id_sala) VALUES (?,?,?,?,?,?)";

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        ps.setString(1, spett.getNome());
        ps.setTime(2, Time.valueOf(spett.getOrario()));
        ps.setInt(3, spett.getDurata());
        ps.setString(4, spett.getGenere());
        ps.setDouble(5, spett.getPrezzo());
        ps.setInt(6, spett.getId_sala());

        int insertedCount = ps.executeUpdate();

        return insertedCount > 0;
    }

    @Override
    public boolean update(Spettacolo spett) throws SQLException {
        String query = "UPDATE teatro.spettacolo SET nome = ?, orario = ?, durata = ?, genere = ?, prezzo = ?, id_sala = ? WHERE id = ?";

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        ps.setString(1, spett.getNome());
        ps.setTime(2, Time.valueOf(spett.getOrario()));
        ps.setInt(3, spett.getDurata());
        ps.setString(4, spett.getGenere());
        ps.setDouble(5, spett.getPrezzo());
        ps.setInt(6, spett.getId_sala());
        ps.setInt(7, spett.getId());

        int updateCount = ps.executeUpdate();

        return updateCount > 0;
    }

    @Override
    public boolean delete(Spettacolo spett) throws SQLException {
        String query = "DELETE FROM teatro.spettacolo WHERE id = ?;";

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, spett.getId());
        int deletedCount = ps.executeUpdate();
        return deletedCount > 0;
    }

    @Override
    public Optional<Spettacolo> getById(int id) throws SQLException {
        String query = "SELECT * FROM teatro.spettacolo WHERE id = ?";

        Optional<Spettacolo> spettacolo = Optional.empty();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) spettacolo = Optional.of(Spettacolo.fromResultSet(rs));
        return spettacolo;
    }

    @Override
    public List<Spettacolo> getAll() throws SQLException {
        String query = "SELECT * FROM teatro.spettacolo";

        List<Spettacolo> spettacoli = new ArrayList<>();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) spettacoli.add(Spettacolo.fromResultSet(rs));

        return spettacoli;
    }

    @Override
    public List<Spettacolo> getSpettacoliByGenere(String genere) throws SQLException {
        String query = "SELECT * FROM teatro.spettacolo " +
                "WHERE genere = ?";


        List<Spettacolo> spettacoli = new ArrayList<>();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);
        ps.setString(1, genere);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) spettacoli.add(Spettacolo.fromResultSet(rs));

        return spettacoli;
    }
}