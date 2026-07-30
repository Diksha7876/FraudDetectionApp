package com.finance.frauddetection.respository;

import com.finance.frauddetection.models.Transaction;

import java.util.List;

public interface ITransactionRepository {
    List<Transaction> findAll();

    Transaction findById(int id);

    int save(Transaction transaction);

    void updateStatus(int id, String status);
}
