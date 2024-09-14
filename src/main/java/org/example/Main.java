package org.example;

import org.example.account.AccountEntity;
import org.example.account.AccountRepository;
import org.example.account.AccountService;
import org.example.branch.BranchEntity;
import org.example.branch.BranchRepository;
import org.example.branch.BranchService;
import org.example.employee.EmployeeEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class)
                .addAnnotatedClass(AccountEntity.class)
                .addAnnotatedClass(AccountRepository.class)
                .addAnnotatedClass(AccountService.class)
                .addAnnotatedClass(BranchEntity.class)
                .addAnnotatedClass(BranchRepository.class)
                .addAnnotatedClass(BranchService.class)
                .buildSessionFactory();



        }
}