package com.tradewise.dto;

public class TradeRequest {

    private String email;
    private String symbol;
    private Integer quantity;

    public TradeRequest() {
    }

    public TradeRequest(String email, String symbol, Integer quantity) {
        this.email = email;
        this.symbol = symbol;
        this.quantity = quantity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}