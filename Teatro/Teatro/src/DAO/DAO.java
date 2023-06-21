package DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<Z> {

    public boolean insert(Z elem) throws SQLException;

    public boolean update(Z elem) throws SQLException;

    public boolean delete(Z elem) throws SQLException;

    public Optional<Z> getById(int id) throws SQLException;

    public List<Z> getAll() throws SQLException;
}
