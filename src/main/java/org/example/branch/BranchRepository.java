package org.example.branch;

import org.example.account.AccountEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utilities.InterfaceRepo;

import java.util.ArrayList;
import java.util.List;

public class BranchRepository implements InterfaceRepo<BranchEntity> {
    private SessionFactory sessionFactory;
    @Override
    public void add(BranchEntity branch) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            session.save(branch);
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
            BranchEntity branch = session.createQuery("Select a From BranchEntity where a.id = :id", BranchEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.delete(branch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public BranchEntity findById(int id) {
        BranchEntity branch = null;
        try (Session session = sessionFactory.openSession()) {
            branch = session.createQuery("Select a From BranchEntity where a.id = :id", BranchEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return branch;
    }

    @Override
    public void update(BranchEntity object, int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            BranchEntity existingBranch = session.get(BranchEntity.class, id);
            if (existingBranch != null) {
                existingBranch.setName(object.getName());
                existingBranch.setCode(object.getCode());
                existingBranch.setAddress(object.getAddress());
                session.update(existingBranch);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
//    private String name;
//    private int code;
//    private String address;
    @Override
    public List<BranchEntity> findAll() {
        List<BranchEntity> list = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            list = session.createQuery("Select a From BranchEntity", BranchEntity.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
