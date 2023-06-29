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

    @Column(nullable = false)
    private float statoRifornimento;

    @Column(nullable = true)
    private String targa;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private TipoPatente patente;

    public Veicolo(){

    }
}
