package com.example.SharedMobility20.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Veicolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoVeicolo tipo;

    @Column(nullable = false)
    private String posizione;

    @Column(nullable = false)
    private boolean isFree;

    @Column(nullable = true)
    private Double statoRifornimento;

    @Column(nullable = true)
    private String targa;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private TipoPatente patente;

    public Veicolo(){

    }

    public Veicolo(TipoVeicolo tipo, String posizione, boolean isFree, Double statoRifornimento, String targa, TipoPatente patente) {
        this(null,tipo, posizione, isFree, statoRifornimento, targa, patente);
    }
}
