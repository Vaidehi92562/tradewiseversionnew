package com.tradewise.controller;

import com.tradewise.model.Stock;
import com.tradewise.repository.StockRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MarketController {

    private final StockRepository stockRepository;

    public MarketController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @GetMapping("/api/market/stocks")
    public List<Stock> getAllActiveStocks() {
        return stockRepository.findByActiveTrue();
    }
}