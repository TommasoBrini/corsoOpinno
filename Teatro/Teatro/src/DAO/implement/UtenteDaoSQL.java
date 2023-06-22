package DAO.implement;

import DAO.dao.UtenteDAO;
import connection_handler.ConnectionHandler;
import model.Utente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UtenteDaoSQL implements UtenteDAO {
    @Override
    public boolean insert(Utente elem) throws SQLException {
        String query = "INSERT INTO teatro.utente(\n" +
                "\t nome, cognome, mail, telefono, indirizzo)\n" +
                "\tVALUES ( ?, ?, ?, ?, ?);";

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();
        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        ps.setString(1, elem.getNome());
        ps.setString(2, elem.getCognome());
        ps.setString(3, elem.getEmail());
        ps.setString(4, elem.getTelefono());
        ps.setString(5, elem.getIndirizzo());


        int insertedCount = ps.executeUpdate();

        return insertedCount > 0;
    }

    @Override
    public boolean update(Utente elem) throws SQLException {
        String query = "UPDATE teatro.utente\n" +
                "\t SET nome=?, cognome=?, mail=?, telefono=?, indirizzo=? \n" +
                "\t WHERE id = ?";

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps = connectionHandler.getPreparedStatement(query);

        ps.setString(1, elem.getNome());
        ps.setString(2, elem.getCognome());
        ps.setString(3, elem.getEmail());
        ps.setString(4, elem.getTelefono());
        ps.setString(5, elem.getIndirizzo());
        ps.setInt(6, elem.getId());

        int updateCount = ps.executeUpdate();

        return updateCount > 0;
    }

    @Override
    public boolean delete(Utente elem) throws SQLException {
        String query = "DELETE FROM teatro.utente\n" +
                "\tWHERE id = ?";

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, elem.getId());
        int deletedCount = ps.executeUpdate();
        return deletedCount > 0;
    }

    @Override
    public Optional<Utente> getById(int id) throws SQLException {
        String query = "SELECT * FROM teatro.utente WHERE id = ?";

        Optional<Utente> utente = Optional.empty();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) utente = Optional.of(Utente.fromResultSet(rs));
        return utente;
    }

    @Override
    public List<Utente> getAll() throws SQLException {
        String query = "SELECT * FROM teatro.utente";

        List<Utente> utenti = new ArrayList<>();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) utenti.add(Utente.fromResultSet(rs));

        return utenti;
    }

    @Override
    public List<Utente> getByLastName(String lastName) throws SQLException {
        String query= "SELECT * FROM teatro.utente WHERE cognome =?";

        List<Utente> utenti = new ArrayList<>();

        ConnectionHandler ch = ConnectionHandler.getInstance();
        PreparedStatement ps = ch.getPreparedStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) utenti.add(Utente.fromResultSet(rs));

        return utenti;
    }
}
