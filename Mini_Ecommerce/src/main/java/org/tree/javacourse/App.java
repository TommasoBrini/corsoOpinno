package org.tree.javacourse;

import org.tree.javacourse.controller.ProdottoController;
import org.tree.javacourse.service.ProdottoService;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ProdottoService prodottoService = new ProdottoService();

        ProdottoController prodottoController = new ProdottoController();
        prodottoController.startServices(prodottoService);
    }
}
