import connection_handler.ConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println("**** SYSTEM STARTUP ****");

        /*
         * TODO: Refactor del codice utilizzando il ConnectionHandler!
         * */

        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();

        PreparedStatement ps =  connectionHandler.getPreparedStatement("SELECT * FROM teatro.utente");

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("nome"));
        }
    }
}