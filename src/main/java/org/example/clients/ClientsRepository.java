package org.example.clients;

import org.example.clients.ClientsEntity;
import org.example.employee.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utilities.InterfaceRepo;

import java.util.ArrayList;
import java.util.List;

public class ClientsRepository implements InterfaceRepo<ClientsEntity> {

    private SessionFactory sessionFactory;

    @Override
    public void add (ClientsEntity clients) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
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
            transaction = session.beginTransaction();
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
    public ClientsEntity findById (int id) {
        ClientsEntity clients = null;
        try (Session session = sessionFactory.openSession()) {
            clients = session.createQuery("Select a From ClientsEntity where a.id = :id", ClientsEntity.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void update (ClientsEntity object, int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            ClientsEntity existingClients= session.get(ClientsEntity.class, id);
            if (existingClients != null) {
                existingClients.setName(object.getName());
                existingClients.setSurname(object.getSurname());
                existingClients.setDateOfBirth(object.getDateOfBirth());
                existingClients.setEmail(object.getEmail());
                existingClients.setPhoneNumber(object.getPhoneNumber());
                existingClients.setAddress(object.getAddress());

                session.update(existingClients);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<ClientsEntity> findAll () {
        List<ClientsEntity> list = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            list = session.createQuery("Select a From ClientsEntity", ClientsEntity.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



    }
