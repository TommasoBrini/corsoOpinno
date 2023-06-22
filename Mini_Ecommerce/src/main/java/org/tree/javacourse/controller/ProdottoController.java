package org.tree.javacourse.controller;

import org.tree.javacourse.service.ProdottoService;

import java.net.http.HttpResponse;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.delete;
import static spark.Spark.put;

import com.google.gson.Gson;

public class ProdottoController {

    public void startService(ProdottoService prodottoService) {

        get("/", (req, res) -> "System is working");

        get("/prodotto/all", (req, res) -> {
            res.type("application/json");

            HttpResponse response = new HttpResponse("200",
                    new Gson().toJsonTree(prodottoService.getAll()));
            return new Gson().toJson(response);
        });
    }
}
