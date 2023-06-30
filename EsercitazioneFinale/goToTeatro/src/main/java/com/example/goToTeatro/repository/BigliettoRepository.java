package com.example.goToTeatro.repository;

import com.example.goToTeatro.entities.Biglietto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BigliettoRepository extends JpaRepository<Biglietto, Long> {

    @Query(value = "SELECT id FROM biglietto WHERE posto_id = :posto AND spettacolo_id = :show", nativeQuery = true)
    Collection<Biglietto> checkBigliettoBooked(@Param("posto") Long p_id, @Param("show") Long s_id);
}
