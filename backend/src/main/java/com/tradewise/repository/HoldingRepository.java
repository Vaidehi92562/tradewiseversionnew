package com.tradewise.repository;

import com.tradewise.model.Holding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HoldingRepository extends JpaRepository<Holding, Long> {
    List<Holding> findByUserEmail(String userEmail);
    Optional<Holding> findByUserEmailAndSymbol(String userEmail, String symbol);
}