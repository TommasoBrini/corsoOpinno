import DAO.dao.*;
import DAO.implement.*;
import connection_handler.ConnectionHandler;
import model.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println("**** SYSTEM STARTUP ****");

        UtenteDAO ud = new UtenteDaoSQL();
        PostoDAO pd = new PostoDaoSQL();
        SpettacoloDAO sd = new SpettacoloDaoSQL();
        SalaDAO salaDAO = new SalaDaoSQL();
        TicketDAO td = new TicketDaoSQL();
        SedeDAO ssd = new SedeDaoSQL();

        //sd.insert(new Spettacolo("bugiardo", LocalTime.now(), 240, "Buffo",232.99,1));

        System.out.println(ud.getAll());
        System.out.println(pd.getAll());
        System.out.println(sd.getAll());
        System.out.println(salaDAO.getAll());
        System.out.println(td.getAll());
        System.out.println(ssd.getAll());


        /*System.out.println(pd.getPostoDisponibileBySpettacolo(sd.getById(1).get()));
        System.out.println(salaDAO.getSalaBySede(1));
        System.out.println(ssd.getSedeIsOpen());*/
        //System.out.println(sd.getSpettacoliByGenere("Commedia"));




    }
}