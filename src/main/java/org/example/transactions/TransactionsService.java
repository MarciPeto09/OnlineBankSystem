package org.example.transactions;

import org.example.transactions.TransactionsEntity;
import org.example.transactions.TransactionsRepository;

import java.util.List;

public class TransactionsService {
    private TransactionsRepository TransactionsRepository;


    public void add (TransactionsEntity employee) {
        TransactionsRepository.add(employee);
    }

    public void remove (int id) {
        TransactionsRepository.remove(id);
    }


    public TransactionsEntity findById (int id) {
        return TransactionsRepository.findById(id);
    }

    public void update (TransactionsEntity object, int id) {
        TransactionsRepository.update(object, id);
    }

    public List<TransactionsEntity> findAll () {
        return TransactionsRepository.findAll();
    }}

