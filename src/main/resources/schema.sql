DROP TABLE IF EXISTS fraud_alert;
DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    account_number VARCHAR(20) NOT NULL UNIQUE,
    registered_country VARCHAR(50) NOT NULL
);

CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    amount DECIMAL(12,2) NOT NULL,
    txn_country VARCHAR(50) NOT NULL,
    txn_timestamp DATETIME NOT NULL,
    status VARCHAR(20) DEFAULT 'PROCESSED',
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE fraud_alert (
    id INT AUTO_INCREMENT PRIMARY KEY,
    transaction_id INT NOT NULL,
    reason VARCHAR(255) NOT NULL,
    risk_score INT NOT NULL,
    alert_status VARCHAR(20) DEFAULT 'OPEN',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (transaction_id) REFERENCES transactions(id)
);
