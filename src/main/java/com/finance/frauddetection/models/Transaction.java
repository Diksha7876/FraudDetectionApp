package com.finance.frauddetection.models;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private int customerId;
    private BigDecimal amount;
    private String txnCountry;
    private LocalDateTime txnTimestamp;
    private String status;

    public Transaction() {}

    public Transaction(int id, int customerId, BigDecimal amount, String txnCountry,
                       LocalDateTime txnTimestamp, String status) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.txnCountry = txnCountry;
        this.txnTimestamp = txnTimestamp;
        this.status = status;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getTxnCountry() { return txnCountry; }
    public void setTxnCountry(String txnCountry) { this.txnCountry = txnCountry; }
    public LocalDateTime getTxnTimestamp() { return txnTimestamp; }
    public void setTxnTimestamp(LocalDateTime txnTimestamp) { this.txnTimestamp = txnTimestamp; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}