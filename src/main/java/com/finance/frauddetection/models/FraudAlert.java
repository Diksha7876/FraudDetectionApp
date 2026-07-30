package com.finance.frauddetection.models;

import java.time.LocalDateTime;

public class FraudAlert {
    private int id;
    private int transactionId;
    private String reason;
    private int riskScore;
    private String alertStatus;
    private LocalDateTime createdAt;

    public FraudAlert() {}

    public FraudAlert(int id, int transactionId, String reason, int riskScore,
                      String alertStatus, LocalDateTime createdAt) {
        this.id = id;
        this.transactionId = transactionId;
        this.reason = reason;
        this.riskScore = riskScore;
        this.alertStatus = alertStatus;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public int getRiskScore() { return riskScore; }
    public void setRiskScore(int riskScore) { this.riskScore = riskScore; }
    public String getAlertStatus() { return alertStatus; }
    public void setAlertStatus(String alertStatus) { this.alertStatus = alertStatus; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
