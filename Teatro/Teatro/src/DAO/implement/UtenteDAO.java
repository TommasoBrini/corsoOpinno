package DAO.implement;

import DAO.DAO;
import repository.UtenteRepo;

import java.util.List;

public class UtenteDAO implements DAO {

    UtenteRepo repoUtente;

    @Override
    public boolean insert(Object elem) {
        return false;
    }

    @Override
    public boolean update(Object elem) {
        return false;
    }

    @Override
    public boolean delete(Object elem) {
        return false;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }
}
