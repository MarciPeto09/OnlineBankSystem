package org.example.account;

import org.example.employee.EmployeeEntity;

import java.util.List;

public class AccountService {
    private AccountRepository accountRepository;

    public void add(AccountEntity account){
        accountRepository.add(account);
    }

    public void remove(int id){
        accountRepository.remove(id);
    }


    public AccountEntity findById(int id){
        return  accountRepository.findById(id);
    }

    public void update(AccountEntity object, int id) {
        accountRepository.update(object, id);
    }

    public List<AccountEntity> findAll() {
        return  accountRepository.findAll();
    }
}
