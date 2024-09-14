package org.example.transactions;

import org.example.clients.ClientsEntity;
import org.example.transactions.TransactionsEntity;
import org.example.employee.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utilities.InterfaceRepo;

import java.util.ArrayList;
import java.util.List;

public class TransactionsRepository implements InterfaceRepo<TransactionsEntity> {

    private SessionFactory sessionFactory;

    @Override
    public void add (TransactionsEntity clients) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            session.save(clients);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove (int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            EmployeeEntity employee = session.createQuery("Select a From EmployeeEntity where a.id = :id", EmployeeEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.delete(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public TransactionsEntity findById (int id) {
        TransactionsEntity clients = null;
        try (Session session = sessionFactory.openSession()) {
            clients = session.createQuery("Select a From ClientsEntity where a.id = :id", TransactionsEntity.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void update (TransactionsEntity object, int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            TransactionsEntity existingTransactions= session.get(TransactionsEntity.class, id);
            if (existingTransactions != null) {
                existingTransactions.setId(object.getId());
                existingTransactions.setType(object.getType());
                existingTransactions.setAmount(object.getAmount());
                existingTransactions.setDate(object.getDate());

                session.update(existingTransactions);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<TransactionsEntity> findAll () {
        List<TransactionsEntity> list = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            list = session.createQuery("Select a From TransactionsEntity", TransactionsEntity.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



}
