package DAO.dao;

import DAO.DAO;
import model.Posto;
import model.Spettacolo;

import java.sql.SQLException;
import java.util.List;

public interface PostoDAO extends DAO<Posto> {

    List<Posto> getPostoDisponibileBySpettacolo(Spettacolo spettacolo) throws SQLException;

}
