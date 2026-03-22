# TradeWise – Live Paper Trading Platform

TradeWise is a full-stack virtual stock trading platform inspired by real trading apps like Upstox. It allows users to register, log in, explore live-style changing stock prices, buy and sell stocks virtually, manage a watchlist, track portfolio performance, and view transaction history — all without using real money.

This project is designed as a DevOps-oriented academic project and demonstrates the integration of frontend, backend, database, live-refresh logic, and deployment/monitoring readiness.

---

## Features

### User Features
- User registration
- User login
- Landing page with navigation
- Live-style market page
- Buy stocks at current live mock price
- Sell stocks from portfolio
- Add stocks to watchlist
- Remove stocks from watchlist
- View portfolio holdings
- View live portfolio value
- View profit/loss (P&L)
- View transaction history
- View live dashboard summary

### Market Features
- Dynamic mock live prices
- Auto-refreshing stock prices
- Stock-wise price change and change percentage
- Filter by sector
- Search by stock symbol/company
- Sort by symbol

### Portfolio Features
- Live price-based current value
- Total invested value
- Total quantity
- Current portfolio value
- Profit/loss calculation

### Watchlist Features
- Live stock price display
- Live movement display
- Remove action from UI

### Dashboard Features
- Actual holdings count
- Live portfolio value
- Real transaction count
- Recent activity
- Watchlist count
- Market highlights

---

## Tech Stack

### Frontend
- HTML
- CSS
- JavaScript

### Backend
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Boot Actuator

### Database
- MySQL

### Build Tool
- Maven

### DevOps / Tools Used
- Git
- GitHub
- Docker
- Docker Compose
- Prometheus
- Grafana
- Kubernetes (planned / YAML deployment level)
- Jenkins (planned for CI/CD alignment with syllabus)

---

## Project Structure

```text
tradewiseversionnew/
│
├── backend/
│   ├── src/main/java/com/tradewise/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── model/
│   │   ├── repository/
│   │   └── service/
│   └── src/main/resources/
│
├── frontend/
│   ├── index.html
│   ├── register.html
│   ├── login.html
│   ├── dashboard.html
│   ├── market.html
│   ├── portfolio.html
│   ├── watchlist.html
│   └── transactions.html
│
├── docker/
├── k8s/
├── .github/workflows/
├── .gitignore
└── README.md