package org.example.service;

import org.example.model.Transaction;
import org.example.repository.TransactionRepository;

public class TransactionService extends BaseService<Transaction, TransactionRepository> {
    private static final TransactionService transactionService = new TransactionService();
    private TransactionService() {
        super(new TransactionRepository());
    }

    public static TransactionService getInstance(){
        return transactionService;
    }

    @Override
    protected boolean checking(Transaction transaction) {
        return false;
    }
}
