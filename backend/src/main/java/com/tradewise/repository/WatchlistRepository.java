package com.tradewise.repository;

import com.tradewise.model.WatchlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WatchlistRepository extends JpaRepository<WatchlistItem, Long> {
    List<WatchlistItem> findByUserEmail(String userEmail);
    Optional<WatchlistItem> findByUserEmailAndSymbol(String userEmail, String symbol);
}