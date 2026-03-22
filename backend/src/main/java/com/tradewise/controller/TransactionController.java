package com.tradewise.controller;

import com.tradewise.model.Transaction;
import com.tradewise.repository.TransactionRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TransactionController {

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/api/transactions")
    public List<Transaction> getTransactions(@RequestParam String email) {
        return transactionRepository.findByUserEmailOrderByTimestampDesc(email);
    }
}