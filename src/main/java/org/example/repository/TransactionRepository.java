package org.example.repository;

import org.example.model.Transaction;

public class TransactionRepository extends BaseRepository<Transaction> {
    {
        path += "transactions.json";
        type = Transaction.class;
    }
}
