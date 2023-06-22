package org.tree.javacourse.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Prodotto {
    @NonNull
    private String nome;
    private Integer id;
    @NonNull
    private String descrizione;
    @NonNull
    private int quantitaStock;
    @NonNull
    private double prezzo;

    public Prodotto(@NonNull String nome, @NonNull String descrizione, @NonNull int quantitaStock, @NonNull double prezzo) {
        this(nome, null, descrizione, quantitaStock, prezzo);
    }
}
