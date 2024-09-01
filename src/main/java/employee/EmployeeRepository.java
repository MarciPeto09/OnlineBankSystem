package employee;


import org.hibernate.*;
import org.hibernate.Transaction;
import utilities.InterfaceRepo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements InterfaceRepo<EmployeeEntity> {

    private SessionFactory sessionFactory;

    @Override
    public void add(EmployeeEntity employee) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.getTransaction();
            session.save(employee);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.getTransaction();
            EmployeeEntity employee = session.createQuery("Select a From EmployeeEntity where a.id = :id",EmployeeEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.delete(employee);
            transaction.commit();
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public EmployeeEntity findById(int id) {
       EmployeeEntity employee = null;
        try(Session session = sessionFactory.openSession()){
             employee = session.createQuery("Select a From EmployeeEntity where a.id = :id",EmployeeEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void update(EmployeeEntity object, int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            EmployeeEntity existingEmployee = session.get(EmployeeEntity.class, id);
            if (existingEmployee != null) {
                existingEmployee.setPosition(object.getPosition());
                session.update(existingEmployee);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    @Override
    public List<EmployeeEntity> findAll() {
        List<EmployeeEntity> list = new ArrayList<>();
        try(Session session = sessionFactory.openSession()){
            list = session.createQuery("Select a From EmployeeEntity",EmployeeEntity.class)
                    .getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
