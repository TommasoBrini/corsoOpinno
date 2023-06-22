package org.tree.javacourse.dao;

import org.tree.javacourse.model.Prodotto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao {
    boolean insert(Prodotto p) throws SQLException;

    boolean update(Prodotto p) throws SQLException;

    boolean delete(int id) throws SQLException;

    Optional<Prodotto> get(int id) throws SQLException;

    List<Prodotto> getAll() throws SQLException;

}
