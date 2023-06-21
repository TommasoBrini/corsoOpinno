package DAO.dao;

import DAO.DAO;
import model.Utente;

import java.sql.SQLException;
import java.util.List;

public interface UtenteDAO extends DAO<Utente> {

    List<Utente> getByLastName(String lastName) throws SQLException;

}
