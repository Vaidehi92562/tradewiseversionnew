package com.tradewise.controller;

import com.tradewise.model.WatchlistItem;
import com.tradewise.repository.WatchlistRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/watchlist")
public class WatchlistController {

    private final WatchlistRepository watchlistRepository;

    public WatchlistController(WatchlistRepository watchlistRepository) {
        this.watchlistRepository = watchlistRepository;
    }

    @PostMapping("/add")
    public Map<String, String> addToWatchlist(@RequestBody WatchlistItem request) {
        Optional<WatchlistItem> existing =
                watchlistRepository.findByUserEmailAndSymbol(request.getUserEmail(), request.getSymbol());

        if (existing.isPresent()) {
            return Map.of(
                    "status", "ERROR",
                    "message", "Stock already in watchlist"
            );
        }

        WatchlistItem item = new WatchlistItem();
        item.setUserEmail(request.getUserEmail());
        item.setSymbol(request.getSymbol());
        watchlistRepository.save(item);

        return Map.of(
                "status", "SUCCESS",
                "message", "Stock added to watchlist"
        );
    }

    @GetMapping
    public List<WatchlistItem> getWatchlist(@RequestParam String email) {
        return watchlistRepository.findByUserEmail(email);
    }

    @DeleteMapping("/remove")
    public Map<String, String> removeFromWatchlist(@RequestParam String email, @RequestParam String symbol) {
        Optional<WatchlistItem> existing =
                watchlistRepository.findByUserEmailAndSymbol(email, symbol);

        if (existing.isEmpty()) {
            return Map.of(
                    "status", "ERROR",
                    "message", "Stock not found in watchlist"
            );
        }

        watchlistRepository.delete(existing.get());

        return Map.of(
                "status", "SUCCESS",
                "message", "Stock removed from watchlist"
        );
    }
}