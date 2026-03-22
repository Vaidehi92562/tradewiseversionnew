package com.tradewise.service;

import com.tradewise.dto.MarketStockResponse;
import com.tradewise.model.Stock;
import com.tradewise.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketService {

    private final StockRepository stockRepository;

    public MarketService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<MarketStockResponse> getAllActiveStocks() {
        List<Stock> stocks = stockRepository.findByActiveTrue();
        List<MarketStockResponse> responseList = new ArrayList<>();

        for (Stock stock : stocks) {
            double price = getMockLivePrice(stock.getSymbol());
            double change = getMockChange(stock.getSymbol());
            double previousPrice = price - change;
            double changePercent = previousPrice != 0 ? (change / previousPrice) * 100 : 0;

            MarketStockResponse response = new MarketStockResponse();
            response.setSymbol(stock.getSymbol());
            response.setCompanyName(stock.getCompanyName());
            response.setSector(stock.getSector());
            response.setExchange(stock.getExchange());
            response.setCurrentPrice(price);
            response.setChange(change);
            response.setChangePercent(changePercent);
            response.setActive(stock.getActive());

            responseList.add(response);
        }

        return responseList;
    }

    public double getMockLivePrice(String symbol) {
    long currentSlot = System.currentTimeMillis() / 2000;

    int basePrice;
    switch (symbol) {
        case "RELIANCE":
            basePrice = 2945;
            break;
        case "TCS":
            basePrice = 4118;
            break;
        case "INFY":
            basePrice = 1782;
            break;
        case "HDFCBANK":
            basePrice = 1603;
            break;
        case "ICICIBANK":
            basePrice = 1215;
            break;
        case "SBIN":
            basePrice = 812;
            break;
        case "ITC":
            basePrice = 438;
            break;
        case "WIPRO":
            basePrice = 562;
            break;
        default:
            basePrice = 100;
    }

    int variation = (int) ((currentSlot + symbol.hashCode()) % 41) - 20;
    return basePrice + variation;
}

   public double getMockChange(String symbol) {
    long currentSlot = System.currentTimeMillis() / 2000;
    int changeSeed = (int) ((currentSlot + symbol.hashCode()) % 15) - 7;
    return changeSeed;
}
}