package org.example.account;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "account")

public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountId;

    public AccountEntity(int number, String password, String type, double balanca, LocalDate opendata, LocalDate closedata, String accountstatus) {
        this.number = number;
        this.password = password;
        this.type = type;
        this.balanca = balanca;
        this.opendata = opendata;
        this.closedata = closedata;
        this.accountstatus = accountstatus;
    }

    private int number;
    private String password;
    private String type;
    private double balanca;
    private LocalDate opendata;
    private LocalDate closedata;
    private String accountstatus;

}
