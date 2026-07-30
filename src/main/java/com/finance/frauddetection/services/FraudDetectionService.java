package com.finance.frauddetection.services;

import com.finance.frauddetection.models.Customer;
import com.finance.frauddetection.models.Transaction;
import com.finance.frauddetection.respository.CustomerRespository;
import com.finance.frauddetection.respository.ITransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FraudDetectionService {
    private ITransactionRepository transactionRepository;
    private CustomerRespository customerRespository;
    public FraudDetectionService(ITransactionRepository transactionRepository,
                                 CustomerRespository customerRespository) {
        this.transactionRepository = transactionRepository;
        this.customerRespository = customerRespository;
    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }
    // getTransactionById()
    public Transaction getTransactionById(int id){
        return transactionRepository.findById(id);
    }

    public Transaction processTransaction(Transaction transaction){
        int newGeneratedIdTxn =  transactionRepository.save(transaction);
        transaction.setId(newGeneratedIdTxn);

        List<String> reasons = new ArrayList<>();
        // FraudDetection
        // 1. Rule -  High Amount if()
        int riskScore = 0;
        if(transaction.getAmount().compareTo(new BigDecimal(1000000)) > 0){
            reasons.add("High transaction amount Rs. (" + transaction.getAmount() + ")" );
            riskScore +=40;
        }
        //2. Rule - Odd Hours
        int hour = transaction.getTxnTimestamp().getHour();
        if(hour>=0 && hour<5){
            reasons.add("Transaction made during odd hours (" + hour + ":00)" );
            riskScore +=20;
        }
        //3. Location Mismatch
        Customer customer = customerRespository.getCustomerById(transaction.getCustomerId());

        if(customer != null && !customer.getRegisteredCountry().equalsIgnoreCase(transaction.getTxnCountry())){
            reasons.add("Customer country mismatched - " + transaction.getTxnCountry()  );
            riskScore +=30;
        }

        if(!reasons.isEmpty()){
            // update transaction status as FLAGGED
            transactionRepository.updateStatus(transaction.getId(),"FLAGGED");
            //
        }else{
            // update transaction status as SUCCESS
            transactionRepository.updateStatus(transaction.getId(),"SUCCESS");
        }
        return transaction;
    }
}