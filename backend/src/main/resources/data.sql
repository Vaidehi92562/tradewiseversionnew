DELETE FROM stocks;

INSERT INTO stocks (symbol, company_name, sector, exchange, active) VALUES
('RELIANCE', 'Reliance Industries', 'Energy', 'NSE', true),
('TCS', 'Tata Consultancy Services', 'IT', 'NSE', true),
('INFY', 'Infosys', 'IT', 'NSE', true),
('HDFCBANK', 'HDFC Bank', 'Banking', 'NSE', true),
('ICICIBANK', 'ICICI Bank', 'Banking', 'NSE', true),
('SBIN', 'State Bank of India', 'Banking', 'NSE', true),
('ITC', 'ITC Limited', 'FMCG', 'NSE', true),
('WIPRO', 'Wipro', 'IT', 'NSE', true);