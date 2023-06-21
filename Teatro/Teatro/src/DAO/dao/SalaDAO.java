package DAO.dao;

import DAO.DAO;
import model.Sala;

import java.sql.SQLException;
import java.util.List;

public interface SalaDAO extends DAO<Sala> {

    List<Sala> getSalaBySede(int id_sede) throws SQLException;

}
