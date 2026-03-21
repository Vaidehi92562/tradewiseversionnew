package com.tradewise.controller;

import com.tradewise.model.Stock;
import com.tradewise.service.MarketService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MarketController {

    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/api/market/stocks")
    public List<Stock> getAllActiveStocks() {
        return marketService.getAllActiveStocks();
    }
}