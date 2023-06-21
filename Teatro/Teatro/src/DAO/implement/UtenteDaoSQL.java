package DAO.implement;

import DAO.dao.UtenteDAO;
import model.Utente;

public class UtenteDaoSQL implements UtenteDAO {
    public Utente save(Utente ut){
        // APRE CONNESSIONE DATABASE TRAMITE CONNECTION HANDLER
        // GESTISCE LA QUERY DI INSERIMENTO
        // CHIUDE LA CONNESSIONE
        /*
        query = "INSeerrfs bla bla "
        id = executeQuery(query)
        ut.setId(id)
        */
        return ut;
    }
}
