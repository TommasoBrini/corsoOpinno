package DAO;

import java.util.List;

public interface DAO<Z> {

    public boolean insert(Z elem);

    public boolean update(Z elem);

    public boolean delete(Z elem);

    public Z getById(int id);

    public List<Z> getAll();
}
