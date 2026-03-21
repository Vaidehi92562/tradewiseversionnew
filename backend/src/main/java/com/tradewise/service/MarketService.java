package com.tradewise.service;

import com.tradewise.model.Stock;
import com.tradewise.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    private final StockRepository stockRepository;

    public MarketService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllActiveStocks() {
        return stockRepository.findByActiveTrue();
    }
}