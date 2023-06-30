package com.example.goToTeatro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Entity
@Table
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Posto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "integer CHECK (fila > 0)")
    private int fila;

    @Column(columnDefinition = "integer CHECK (numero > 0)")
    private int numero;

    @ManyToOne
    private Sala sala;

}
