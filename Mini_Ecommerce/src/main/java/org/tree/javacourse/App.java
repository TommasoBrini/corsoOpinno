package org.tree.javacourse;

import org.tree.javacourse.controller.ProdottoController;
import org.tree.javacourse.dao.Dao;
import org.tree.javacourse.dao.ProdottoDaoImpl;
import org.tree.javacourse.model.Prodotto;
import org.tree.javacourse.service.ProdottoService;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args ) throws SQLException {
        System.out.println( "Hello World!" );
        /*ProdottoService prodottoService = new ProdottoService();

        ProdottoController prodottoController = new ProdottoController();
        prodottoController.startServices(prodottoService);*/


        Dao prodottoDAO = new ProdottoDaoImpl();

        prodottoDAO.insert(new Prodotto("Cocaina", "Pura e legale", 50, 1000));

    }
}
