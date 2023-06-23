package org.tree.javacourse.dao;

import org.tree.javacourse.connection_handler.ConnectionHandler;
import org.tree.javacourse.model.Prodotto;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        // QUERY UPDATE DATABASE
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        // QUERY DELETE DATABASE
        return false;
    }

    @Override
    public Optional<Prodotto> get(int id) throws SQLException {
        // QUERY SELECT DATABASE
        return Optional.empty();
    }

    @Override
    public List<Prodotto> getAll() throws SQLException {
        // QUERY SELECT ALL DATABASE
        return null;
    }
}
