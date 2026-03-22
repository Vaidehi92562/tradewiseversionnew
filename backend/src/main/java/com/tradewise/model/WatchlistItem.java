package com.tradewise.model;

import jakarta.persistence.*;

@Entity
@Table(name = "watchlist")
public class WatchlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    private String symbol;

    public WatchlistItem() {
    }

    public WatchlistItem(Long id, String userEmail, String symbol) {
        this.id = id;
        this.userEmail = userEmail;
        this.symbol = symbol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}