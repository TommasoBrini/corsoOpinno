package DAO.dao;

import DAO.DAO;
import model.Sede;

import java.sql.SQLException;
import java.util.List;

public interface SedeDAO extends DAO<Sede> {
    List<Sede> getSedeIsOpen() throws SQLException;
}
