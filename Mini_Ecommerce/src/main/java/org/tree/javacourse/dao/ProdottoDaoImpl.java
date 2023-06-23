package org.tree.javacourse.dao;

import org.tree.javacourse.connection_handler.ConnectionHandler;
import org.tree.javacourse.model.Prodotto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdottoDaoImpl implements Dao{
    @Override
    public boolean insert(Prodotto p) throws SQLException {
        // QUERY DI INSERIMENTO DATABASE
        String query = "INSERT INTO prodotto (nome, descrizione, quantitastock, prezzo) VALUES (?, ?, ?, ?)";
        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        ps.setString(1, p.getNome());
        ps.setString(2, p.getDescrizione());
        ps.setInt(3, p.getQuantitaStock());
        ps.setDouble(4, p.getPrezzo());

        ps.executeUpdate();

        return true;
    }

    @Override
    public boolean update(Prodotto p) throws SQLException {
        String query = "UPDATE prodotto SET nome = ?, descrizione = ?, quantitastock = ?, prezzo = ? WHERE id = ?";

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        ps.setString(1, p.getNome());
        ps.setString(2, p.getDescrizione());
        ps.setInt(3, p.getQuantitaStock());
        ps.setDouble(3, p.getPrezzo());
        ps.setInt(4, p.getId());

        int updateCount = ps.executeUpdate();

        return updateCount > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM prodotto WHERE id = ?;";

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, id);
        int deletedCount = ps.executeUpdate();
        return deletedCount > 0;
    }

    @Override
    public Optional<Prodotto> get(int id) throws SQLException {
        String query = "SELECT * FROM prodotto WHERE id = ?";

        Optional<Prodotto> p = Optional.empty();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) p = Optional.of(new Prodotto(rs.getString("nome"), rs.getString("descrizione"), rs.getInt("quantitastock"), rs.getDouble("prezzo")));
        return p;
    }

    @Override
    public List<Prodotto> getAll() throws SQLException {
        String query = "SELECT * FROM prodotto WHERE id = ?";

        List<Prodotto> p = new ArrayList<>();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) p.add(new Prodotto(rs.getString("nome"), rs.getString("descrizione"), rs.getInt("quantitastock"), rs.getDouble("prezzo")));
        return p;
    }
}
