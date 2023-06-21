package DAO.dao;

import DAO.DAO;
import model.Spettacolo;

import java.sql.SQLException;
import java.util.List;

public interface SpettacoloDAO extends DAO<Spettacolo> {

    List<Spettacolo> getSpettacoliByGenere(String genere) throws SQLException;

}
