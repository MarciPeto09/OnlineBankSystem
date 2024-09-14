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
                .addAnnotatedClass(BranchEntity.class)
                .buildSessionFactory();






        AccountService accountService = new AccountService(sessionFactory);
        AccountEntity acc = new AccountEntity();
        accountService.add(acc);

     //   AccountEntity acc = new AccountEntity(321,"hR4!8mZ#pQ2w@1","Savings Account", 1.234.56, );
//        AccountEntity acc = new AccountEntity(321,"3y^Z9*vGx!Aq4$","Checking Account", 7.890.12, );
//        AccountEntity acc = new AccountEntity(321,"L8nF%0m#T$7vJp","Joint Account", 45.678.90);
//        AccountEntity acc = new AccountEntity(321,"xX5&Wv1!zP2@7K","Fixed Deposit Account", 3.210.450, );
//        AccountEntity acc = new AccountEntity(321,"R3#pB7$gN1y^Qw","Recurring Deposit Account",10,987.65);
//        AccountEntity acc = new AccountEntity(321,"k@4G!9T$x5nF2Z","Money Market Account",15,20,734);
//        AccountEntity acc = new AccountEntity(321,"V2r^7W!xB1#qP8","Business Account",8,765.43);
//        AccountEntity acc = new AccountEntity(321,"1mZ#7p^L3kV!5w","Student Account",1,111.22);
//        AccountEntity acc = new AccountEntity(321,"y5$P8!vG^Z1@r4","Salary Account",93,847.56);
//        AccountEntity acc = new AccountEntity(321,"H4#j3$R@8nX6!v","NRA (Non-Resident Albania) Account,2,718.28);
//        AccountEntity acc = new AccountEntity(321,"d@3F!9vZ5^M0xB","Individual Retirement Account (IRA)",56,789.01);
//        AccountEntity acc = new AccountEntity(321,"T8&zW!7#q1R^4K","Custodial Account",12,345.67);
//        AccountEntity acc = new AccountEntity(321,"9P$k3@vN2!Z8rY","High-Yield Savings Account",9,876.54);
//        AccountEntity acc = new AccountEntity(321,"q2!WvX^5L$8nG7","Trust Account",4,567.89);
//        AccountEntity acc = new AccountEntity(321,"Y7#m^9t@P4!Bz5","Offshore Account", 21,987.65);
//        AccountEntity acc = new AccountEntity(321,"f@8!V9k$R#1Z7x","Senior Citizen Account",3,400.5 );
//        AccountEntity acc = new AccountEntity(321,"f@8!V9k$R#1Z7x","Current Account",987,654.32);
//        AccountEntity acc = new AccountEntity(321,"jX3$7y^QvP@1!6","Sweep-In Account",1,234,567);
//        AccountEntity acc = new AccountEntity(321,"M0!kL^4p5@#Z8x","Foreign Currency Account",72,815.40);
//        AccountEntity acc = new AccountEntity(321,"r7W^!P9m$4@1Yv","Health Savings Account (HSA)", 18,364.79);
//
////
////Open Date:  15, 2018 | Close Date: March 22, 2021
////Open Date: April 10, 2020 | Close Date: August 19, 2023
////Open Date: July 3, 2015 | Close Date: December 31, 2019
////Open Date: November 28, 2021 | Close Date: June 5, 2024
////Open Date: February 14, 2017 | Close Date: April 30, 2020
////Open Date: March 1, 2016 | Close Date: October 15, 2022
////Open Date: May 23, 2019 | Close Date: September 17, 2023
////Open Date: August 11, 2013 | Close Date: February 6, 2018
////Open Date: December 5, 2014 | Close Date: July 29, 2021
////Open Date: October 20, 2022 | Close Date: January 10, 2024
////Open Date: June 16, 2017 | Close Date: November 25, 2020
////Open Date: September 8, 2018 | Close Date: May 1, 2022
////Open Date: January 7, 2021 | Close Date: August 15, 2023
////Open Date: April 18, 2015 | Close Date: December 30, 2018
////Open Date: July 25, 2016 | Close Date: March 11, 2019
////Open Date: November 13, 2012 | Close Date: June 27, 2016
////Open Date: February 9, 2014 | Close Date: September 20, 2017
////Open Date: May 30, 2019 | Close Date: April 4, 2023
////Open Date: August 14, 2011 | Close Date: January 1, 2015
////Open Date: December 1, 2018 | Close Date: July 10, 2022
//

        }
}