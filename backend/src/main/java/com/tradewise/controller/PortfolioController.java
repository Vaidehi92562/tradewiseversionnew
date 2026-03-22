package com.tradewise.controller;

import com.tradewise.model.Holding;
import com.tradewise.repository.HoldingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PortfolioController {

    private final HoldingRepository holdingRepository;

    public PortfolioController(HoldingRepository holdingRepository) {
        this.holdingRepository = holdingRepository;
    }

    @GetMapping("/api/portfolio")
    public List<Holding> getPortfolio(@RequestParam String email) {
        return holdingRepository.findByUserEmail(email);
    }
}