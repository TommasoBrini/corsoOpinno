package org.tree.javacourse.dao;

import org.tree.javacourse.model.Prodotto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProdottoDaoImpl implements Dao{
    @Override
    public boolean insert(Prodotto p) throws SQLException {
        // QUUERY DI INSERIMENTO DATABASE
        return false;
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
