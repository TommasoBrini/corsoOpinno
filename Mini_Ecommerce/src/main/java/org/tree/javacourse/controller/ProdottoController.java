package org.tree.javacourse.controller;

import org.tree.javacourse.model.Prodotto;
import org.tree.javacourse.service.ProdottoService;
import org.tree.javacourse.controller.response.HttpResponse;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.delete;
import static spark.Spark.put;

import com.google.gson.Gson;

public class ProdottoController {

    public void startServices(ProdottoService prodottoService) {

        get("/", (req, res) -> "System is working");

        get("/prodotto/all", (req, res) -> {
            res.type("application/json");

            HttpResponse response = new HttpResponse("200",
                    new Gson().toJsonTree(prodottoService.getAll()));
            return new Gson().toJson(response);
        });

        post("/prodotto", (req,res) -> {
            res.type("application/json");

            Prodotto prodottoFromPostRequest = new Gson().fromJson(req.body(), Prodotto.class);
            prodottoService.insert(prodottoFromPostRequest);

            return new Gson().toJson(new HttpResponse("200"));
        });

        put("/prodotto", (req, res) -> {
            res.type("application/json");

            Prodotto prodottoFromPostRequest = new Gson().fromJson(req.body(), Prodotto.class);
            prodottoService.update(prodottoFromPostRequest);

            return new Gson().toJson(new HttpResponse("200"));

        });

        delete("/prodotto/:id", (req, res) -> {
            res.type("application/json");

            String paramID = req.params("id");
            prodottoService.delete(Integer.valueOf(paramID));

            return new Gson().toJson(new HttpResponse("200"));
        });

    }
}
