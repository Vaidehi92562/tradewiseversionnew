package com.tradewise.service;

import com.tradewise.dto.TradeRequest;
import com.tradewise.model.Holding;
import com.tradewise.model.Stock;
import com.tradewise.model.Transaction;
import com.tradewise.repository.HoldingRepository;
import com.tradewise.repository.StockRepository;
import com.tradewise.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TradeService {

    private final HoldingRepository holdingRepository;
    private final TransactionRepository transactionRepository;
    private final StockRepository stockRepository;
    private final MarketService marketService;

    public TradeService(HoldingRepository holdingRepository,
                        TransactionRepository transactionRepository,
                        StockRepository stockRepository,
                        MarketService marketService) {
        this.holdingRepository = holdingRepository;
        this.transactionRepository = transactionRepository;
        this.stockRepository = stockRepository;
        this.marketService = marketService;
    }

    public Map<String, String> buyStock(TradeRequest request) {
        Map<String, String> response = new HashMap<>();

        Optional<Stock> stockOptional = stockRepository.findBySymbol(request.getSymbol());
        if (stockOptional.isEmpty()) {
            response.put("status", "ERROR");
            response.put("message", "Stock not found");
            return response;
        }

        double tradePrice = marketService.getMockLivePrice(request.getSymbol());

        Optional<Holding> holdingOptional =
                holdingRepository.findByUserEmailAndSymbol(request.getEmail(), request.getSymbol());

        if (holdingOptional.isPresent()) {
            Holding holding = holdingOptional.get();

            int oldQuantity = holding.getQuantity();
            double oldAveragePrice = holding.getAverageBuyPrice();
            int boughtQuantity = request.getQuantity();

            int newQuantity = oldQuantity + boughtQuantity;
            double newAveragePrice =
                    ((oldQuantity * oldAveragePrice) + (boughtQuantity * tradePrice)) / newQuantity;

            holding.setQuantity(newQuantity);
            holding.setAverageBuyPrice(newAveragePrice);
            holdingRepository.save(holding);
        } else {
            Holding newHolding = new Holding();
            newHolding.setUserEmail(request.getEmail());
            newHolding.setSymbol(request.getSymbol());
            newHolding.setQuantity(request.getQuantity());
            newHolding.setAverageBuyPrice(tradePrice);
            holdingRepository.save(newHolding);
        }

        Transaction transaction = new Transaction();
        transaction.setUserEmail(request.getEmail());
        transaction.setSymbol(request.getSymbol());
        transaction.setType("BUY");
        transaction.setQuantity(request.getQuantity());
        transaction.setPrice(tradePrice);
        transaction.setTotalAmount(tradePrice * request.getQuantity());
        transaction.setTimestamp(LocalDateTime.now());
        transactionRepository.save(transaction);

        response.put("status", "SUCCESS");
        response.put("message", "Stock bought successfully at live price");
        response.put("price", String.valueOf(tradePrice));
        return response;
    }

    public Map<String, String> sellStock(TradeRequest request) {
        Map<String, String> response = new HashMap<>();

        Optional<Holding> holdingOptional =
                holdingRepository.findByUserEmailAndSymbol(request.getEmail(), request.getSymbol());

        if (holdingOptional.isEmpty()) {
            response.put("status", "ERROR");
            response.put("message", "Holding not found");
            return response;
        }

        Holding holding = holdingOptional.get();

        if (holding.getQuantity() < request.getQuantity()) {
            response.put("status", "ERROR");
            response.put("message", "Not enough quantity to sell");
            return response;
        }

        double tradePrice = marketService.getMockLivePrice(request.getSymbol());

        int remainingQuantity = holding.getQuantity() - request.getQuantity();

        if (remainingQuantity == 0) {
            holdingRepository.delete(holding);
        } else {
            holding.setQuantity(remainingQuantity);
            holdingRepository.save(holding);
        }

        Transaction transaction = new Transaction();
        transaction.setUserEmail(request.getEmail());
        transaction.setSymbol(request.getSymbol());
        transaction.setType("SELL");
        transaction.setQuantity(request.getQuantity());
        transaction.setPrice(tradePrice);
        transaction.setTotalAmount(tradePrice * request.getQuantity());
        transaction.setTimestamp(LocalDateTime.now());
        transactionRepository.save(transaction);

        response.put("status", "SUCCESS");
        response.put("message", "Stock sold successfully at live price");
        response.put("price", String.valueOf(tradePrice));
        return response;
    }
}