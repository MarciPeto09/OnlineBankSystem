package org.example.account;

import lombok.AllArgsConstructor;
import org.example.employee.EmployeeEntity;
import org.hibernate.SessionFactory;

import java.util.List;


@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;
    private SessionFactory sessionFactory;

    public AccountService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        accountRepository = new AccountRepository(sessionFactory);
    }

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
