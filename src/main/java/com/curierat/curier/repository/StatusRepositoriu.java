package com.curierat.curier.repository;

import com.curierat.curier.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepositoriu extends JpaRepository<Status,Integer> {
}
