package org.example;

import org.example.account.AccountEntity;
import org.example.account.AccountRepository;
import org.example.account.AccountService;
import org.example.branch.BranchEntity;
import org.example.branch.BranchRepository;
import org.example.branch.BranchService;
import org.example.clients.ClientsEntity;
import org.example.clients.ClientsRepository;
import org.example.clients.ClientsService;
import org.example.employee.EmployeeEntity;
import org.example.employee.EmployeeRepository;
import org.example.employee.EmployeeService;
import org.example.transactions.TransactionsEntity;
import org.example.transactions.TransactionsRepository;
import org.example.transactions.TransactionsService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class)
                .addAnnotatedClass(AccountEntity.class)
                .addAnnotatedClass(BranchEntity.class)
                .addAnnotatedClass(TransactionsEntity.class)
                .addAnnotatedClass(ClientsEntity.class)
                .buildSessionFactory();


        ClientsEntity client1 = new ClientsEntity("John", "Doe", LocalDate.of(1985, 5, 15), "john.doe@example.com", 1234567890, "123 Elm St.");
        ClientsEntity client2 = new ClientsEntity("Jane", "Smith", LocalDate.of(1990, 8, 20), "jane.smith@example.com", 234567, "456 Oak St.");
        ClientsEntity client3 = new ClientsEntity("Michael", "Johnson", LocalDate.of(1980, 9, 5), "michael.j@example.com", 3489012, "789 Pine St.");
        ClientsEntity client4 = new ClientsEntity("Sarah", "Brown", LocalDate.of(1992, 11, 25), "sarah.b@example.com", 4567123, "321 Maple Ave.");
        ClientsEntity client5 = new ClientsEntity("Emily", "Davis", LocalDate.of(1988, 3, 10), "emily.d@example.com", 567234, "654 Cedar St.");
        ClientsEntity client6 = new ClientsEntity("David", "Wilson", LocalDate.of(1975, 6, 15), "david.w@example.com", 67812345, "789 Oak St.");
        ClientsEntity client7 = new ClientsEntity("Karen", "Lee", LocalDate.of(1995, 12, 1), "karen.lee@example.com", 78903456, "101 River Rd.");
        ClientsEntity client8 = new ClientsEntity("Paul", "Martinez", LocalDate.of(1983, 1, 30), "paul.m@example.com", 89034567, "1214 Lake Blvd.");
        ClientsEntity client9 = new ClientsEntity("Linda", "Clark", LocalDate.of(1977, 4, 20), "linda.c@example.com", 901234678, "1315 River Ave.");
        ClientsEntity client10 = new ClientsEntity("James", "Lewis", LocalDate.of(1981, 7, 22), "james.l@example.com", 1012345679, "1416 Bay Rd.");
        //Shtim clientsne database
        ClientsRepository clientsRepository = new ClientsRepository(sessionFactory);
        ClientsService clientsService = new ClientsService(clientsRepository);
        clientsService.add(client1);
        clientsService.add(client2);
        clientsService.add(client3);
        clientsService.add(client4);
        clientsService.add(client5);
        clientsService.add(client6);
        clientsService.add(client7);
        clientsService.add(client8);
        clientsService.add(client9);
        clientsService.add(client10);



        AccountEntity acc1 = new AccountEntity(1692565596, "hR4!8mZ#pQ2w@1", "Savings Account", 123.456, LocalDate.of(2018, 1, 15), LocalDate.of(2021, 3, 22), "Active",client1);
        AccountEntity acc2 = new AccountEntity(1692565597, "pQ1!3aZ#oT9y@2", "Checking Account", 500.75, LocalDate.of(2019, 2, 18), null, "Active",client2);
        AccountEntity acc3 = new AccountEntity(1692565598, "tY5!7mK#uW3r@4", "Business Account", 2000.32, LocalDate.of(2020, 3, 25), null, "Active",client3);
        AccountEntity acc4 = new AccountEntity(1692565599, "uO2!6jH#nP8d@3", "Savings Account", 765.45, LocalDate.of(2020, 5, 10), LocalDate.of(2022, 6, 30), "Closed",client4);
        AccountEntity acc5 = new AccountEntity(1692565600, "kQ4!8fM#rT6e@5", "Joint Account", 1500.00, LocalDate.of(2021, 7, 20), null, "Active",client5);
        AccountEntity acc6 = new AccountEntity(1692565601, "yL3!9vG#bQ5c@6", "Savings Account", 350.75, LocalDate.of(2017, 8, 12), LocalDate.of(2019, 11, 1), "Closed",client6);
        AccountEntity acc7 = new AccountEntity(1692565602, "mT1!4pN#xV7z@7", "Checking Account", 600.12, LocalDate.of(2022, 10, 4), null, "Active",client7);
        AccountEntity acc8 = new AccountEntity(1692565603, "oU6!2aS#qK9r@8", "Business Account", 5000.55, LocalDate.of(2021, 11, 28), null, "Active",client8);
        AccountEntity acc9 = new AccountEntity(1692565604, "iR9!5jB#yL4o@9", "Savings Account", 800.60, LocalDate.of(2023, 4, 1), null, "Active",client9);
        AccountEntity acc10 = new AccountEntity(1692565605, "wE2!7vF#lQ8u@0", "Checking Account", 1230.99, LocalDate.of(2016, 12, 9), LocalDate.of(2020, 1, 15), "Closed",client10);

        //Shtim acc ne database
        AccountRepository accountRepository = new AccountRepository(sessionFactory);
        AccountService accountService = new AccountService(accountRepository);
        accountService.add(acc1);
        accountService.add(acc2);
        accountService.add(acc3);
        accountService.add(acc4);
        accountService.add(acc5);
        accountService.add(acc6);
        accountService.add(acc7);
        accountService.add(acc8);
        accountService.add(acc9);
        accountService.add(acc10);




        TransactionsEntity transaction1 = new TransactionsEntity("Deposit", "500.00", LocalDate.of(2021, 5, 12), List.of(acc1, acc2));
        TransactionsEntity transaction2 = new TransactionsEntity("Withdrawal", "200.00", LocalDate.of(2022, 3, 18), List.of(acc3, acc4));
        TransactionsEntity transaction3 = new TransactionsEntity("Deposit", "1000.00", LocalDate.of(2021, 11, 1), List.of(acc5, acc6));
        TransactionsEntity transaction4 = new TransactionsEntity("Withdrawal", "300.00", LocalDate.of(2020, 12, 24), List.of(acc7, acc8));
        TransactionsEntity transaction5 = new TransactionsEntity("Deposit", "150.00", LocalDate.of(2022, 1, 15), List.of(acc9, acc10));
        TransactionsEntity transaction6 = new TransactionsEntity("Deposit", "700.00", LocalDate.of(2019, 9, 7), List.of(acc1, acc3));
        TransactionsEntity transaction7 = new TransactionsEntity("Withdrawal", "500.00", LocalDate.of(2021, 2, 20), List.of(acc2, acc4));
        TransactionsEntity transaction8 = new TransactionsEntity("Deposit", "850.00", LocalDate.of(2022, 6, 30), List.of(acc5, acc7));
        TransactionsEntity transaction9 = new TransactionsEntity("Withdrawal", "250.00", LocalDate.of(2020, 4, 25), List.of(acc6, acc8));
        TransactionsEntity transaction10 = new TransactionsEntity("Deposit", "400.00", LocalDate.of(2018, 8, 15), List.of(acc9, acc10));

        TransactionsRepository transactionsRepository = new TransactionsRepository(sessionFactory);
        TransactionsService transactionsService = new TransactionsService(transactionsRepository);
        transactionsService.add(transaction1);
        transactionsService.add(transaction2);
        transactionsService.add(transaction3);
        transactionsService.add(transaction4);
        transactionsService.add(transaction5);
        transactionsService.add(transaction6);
        transactionsService.add(transaction7);
        transactionsService.add(transaction8);
        transactionsService.add(transaction9);
        transactionsService.add(transaction10);



        BranchEntity branch1 = new BranchEntity("Central Branch", 101, "123 Main St.");
        BranchEntity branch2 = new BranchEntity("West Side Branch", 102, "456 West St.");
        BranchEntity branch3 = new BranchEntity("East Side Branch", 103, "789 East St.");
        BranchEntity branch4 = new BranchEntity("North Branch", 104, "321 North St.");
        BranchEntity branch5 = new BranchEntity("South Branch", 105, "654 South St.");
        BranchEntity branch6 = new BranchEntity("Hilltop Branch", 106, "789 Hilltop Ave.");
        BranchEntity branch7 = new BranchEntity("Beachside Branch", 107, "100 Beach Rd.");
        BranchEntity branch8 = new BranchEntity("Parkside Branch", 108, "111 Park Lane");
        BranchEntity branch9 = new BranchEntity("Downtown Branch", 109, "222 City Blvd.");
        BranchEntity branch10 = new BranchEntity("Uptown Branch", 110, "333 Uptown St.");

        BranchRepository branchRepository = new BranchRepository(sessionFactory);
        BranchService  branchService = new BranchService(branchRepository);
        branchService.add(branch1);
        branchService.add(branch2);
        branchService.add(branch3);
        branchService.add(branch4);
        branchService.add(branch5);
        branchService.add(branch6);
        branchService.add(branch7);
        branchService.add(branch8);
        branchService.add(branch9);
        branchService.add(branch10);

        EmployeeEntity emp1 = new EmployeeEntity("Manager",branch1);
        EmployeeEntity emp2 = new EmployeeEntity("Teller",branch1);
        EmployeeEntity emp3 = new EmployeeEntity("Clerk",branch2);
        EmployeeEntity emp4 = new EmployeeEntity("Cashier",branch3);
        EmployeeEntity emp5 = new EmployeeEntity("Supervisor",branch1);
        EmployeeEntity  emp6 = new EmployeeEntity("Accountant",branch1);
        EmployeeEntity emp7 = new EmployeeEntity("Security",branch4);
        EmployeeEntity emp8 = new EmployeeEntity("Assistant Manager",branch5);
        EmployeeEntity emp9 = new EmployeeEntity("Receptionist",branch1);
        EmployeeEntity emp10 = new EmployeeEntity("IT Specialist",branch6);

        EmployeeRepository employeeRepository = new EmployeeRepository(sessionFactory);
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        employeeService.add(emp1);
        employeeService.add(emp2);
        employeeService.add(emp3);
        employeeService.add(emp4);
        employeeService.add(emp5);
        employeeService.add(emp6);
        employeeService.add(emp7);
        employeeService.add(emp8);
        employeeService.add(emp9);
        employeeService.add(emp10);

    }
}