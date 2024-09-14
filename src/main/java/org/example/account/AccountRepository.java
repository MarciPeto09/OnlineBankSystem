package org.example.account;

import org.example.account.AccountEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utilities.InterfaceRepo;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements InterfaceRepo<AccountEntity> {
    private SessionFactory sessionFactory;

    public AccountRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(AccountEntity account) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            AccountEntity account = session.createQuery("Select a From AccountEntity where a.id = :id", AccountEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.delete(account);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public AccountEntity findById(int id) {
        AccountEntity account = null;
        try (Session session = sessionFactory.openSession()) {
            account = session.createQuery("Select a From AccountEntity where a.id = :id", AccountEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void update(AccountEntity object, int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            AccountEntity existingAccount = session.get(AccountEntity.class, id);
            if (existingAccount != null) {
                existingAccount.setBalanca(object.getBalanca());
                existingAccount.setNumber(object.getNumber());
                existingAccount.setPassword(object.getPassword());
                existingAccount.setType(object.getType());
                existingAccount.setOpendata(object.getOpendata());
                existingAccount.setClosedata(object.getClosedata());
                existingAccount.setAccountstatus(object.getAccountstatus());
                session.update(existingAccount);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<AccountEntity> findAll() {
        List<AccountEntity> list = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            list = session.createQuery("Select a From AccountEntity", AccountEntity.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}