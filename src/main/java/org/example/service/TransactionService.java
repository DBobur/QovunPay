package org.example.service;

import org.example.model.Transaction;
import org.example.repository.TransactionRepository;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class TransactionService extends BaseService<Transaction, TransactionRepository> {
    private static final TransactionService transactionService = new TransactionService();
    private TransactionService() {
        super(new TransactionRepository());
    }

    public static TransactionService getInstance(){
        return transactionService;
    }

    public ArrayList<Transaction> getAllUserTransactionsLastWeek(UUID userId){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime lastWeek = LocalDateTime.now().minusWeeks(1);
        return getAll().stream().filter(transaction -> Objects.equals(transaction.getOwner(),userId)
                && transaction.getCreatedDate().isAfter(lastWeek)
        && transaction.getCreatedDate().isBefore(now)).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Transaction> getAllUserTransactionsLastMonth(UUID userId){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime lastWeek = LocalDateTime.now().minusMonths(1);
        return getAll().stream().filter(transaction -> Objects.equals(transaction.getOwner(),userId)
                && transaction.getCreatedDate().isAfter(lastWeek)
                && transaction.getCreatedDate().isBefore(now)).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Transaction> getAllUserTransactionsPeriod(UUID userId){
        return getAll().stream().filter(transaction -> Objects.equals(transaction.getOwner(),
                userId)).collect(Collectors.toCollection(ArrayList::new));
    }


    @Override
    protected boolean checking(Transaction transaction) {
        return false;
    }
}
