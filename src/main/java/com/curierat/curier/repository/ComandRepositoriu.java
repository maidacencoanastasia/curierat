package com.curierat.curier.repository;

import com.curierat.curier.model.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComandRepositoriu extends JpaRepository<Comanda,Integer> {
}
