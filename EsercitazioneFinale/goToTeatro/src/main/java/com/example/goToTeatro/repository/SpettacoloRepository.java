package com.example.goToTeatro.repository;

import com.example.goToTeatro.entities.Spettacolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpettacoloRepository extends JpaRepository<Spettacolo, Long> {
}
