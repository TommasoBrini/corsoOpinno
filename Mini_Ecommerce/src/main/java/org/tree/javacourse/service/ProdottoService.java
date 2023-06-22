package org.tree.javacourse.service;

import org.tree.javacourse.dao.Dao;
import org.tree.javacourse.dao.ProdottoDaoImpl;
import org.tree.javacourse.model.Prodotto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProdottoService {

    Dao daoProdotto;

    public ProdottoService(){
        daoProdotto = new ProdottoDaoImpl();
    }

    public boolean insert(Prodotto p) throws SQLException{
        return daoProdotto.insert(p);
    }

    public boolean update(Prodotto p) throws SQLException{
        return daoProdotto.update(p);
    }

    public boolean delete(int id) throws SQLException{
        return daoProdotto.delete(id);
    }

    public Optional<Prodotto> get(int id) throws SQLException{
        return daoProdotto.get(id);
    }

    public List<Prodotto> getAll() throws SQLException{
        return daoProdotto.getAll();
    }
}
