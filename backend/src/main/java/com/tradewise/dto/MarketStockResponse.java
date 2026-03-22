package com.tradewise.dto;

public class MarketStockResponse {

    private String symbol;
    private String companyName;
    private String sector;
    private String exchange;
    private Double currentPrice;
    private Double change;
    private Double changePercent;
    private Boolean active;

    public MarketStockResponse() {
    }

    public MarketStockResponse(String symbol, String companyName, String sector, String exchange,
                               Double currentPrice, Double change, Double changePercent, Boolean active) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.sector = sector;
        this.exchange = exchange;
        this.currentPrice = currentPrice;
        this.change = change;
        this.changePercent = changePercent;
        this.active = active;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(Double changePercent) {
        this.changePercent = changePercent;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}