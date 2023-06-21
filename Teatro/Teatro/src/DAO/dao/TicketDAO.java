package DAO.dao;

import DAO.DAO;
import model.Spettacolo;
import model.Ticket;

import java.sql.SQLException;

public interface TicketDAO extends DAO<Ticket> {

    int getBigliettiVenduti(Spettacolo spettacolo) throws SQLException;

}
