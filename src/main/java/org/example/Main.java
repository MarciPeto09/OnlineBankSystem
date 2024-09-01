package org.example;

import employee.EmployeeEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

public class Main {
    public static void main(String[] args) {
        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class)
                .buildSessionFactory();


    }
}