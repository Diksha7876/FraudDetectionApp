package com.finance.frauddetection.respository;

import com.finance.frauddetection.models.Transaction;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@Profile("inmemory")
public class InMemoryTransactionRepository implements ITransactionRepository {
    private List<Transaction> transactions = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public List<Transaction> findAll() {
        return  transactions;
    }

    @Override
    public Transaction findById(int id){
        for(Transaction transaction : transactions){
            if(transaction.getId() == id){
                return transaction;
            }
        }
        return null;
    }
    @Override
    public int save(Transaction transaction){

        int newId = idCounter.getAndIncrement();
        transaction.setId(newId);
        transactions.add(transaction);// insert
        return newId; // this is new transactionId that got added
    }

    @Override
    public void updateStatus(int id, String status){
        Transaction txn = findById(id);
        if(txn != null){
            txn.setStatus(status);
        }

    }

}