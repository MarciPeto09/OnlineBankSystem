package org.example.account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
@Entity
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountId;
    private int number;
    private String password;
    private String type;
    private double balanca;
    private LocalDate opendata;
    private LocalDate closedata;
    private String accountstatus;

}
