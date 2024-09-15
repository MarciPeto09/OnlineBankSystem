package org.example.account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.clients.ClientsEntity;
import org.example.transactions.TransactionsEntity;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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

    @ManyToOne
   @JoinColumn(name = "clients_id")
    private ClientsEntity clients;


    @ManyToMany(mappedBy = "accountEntityList")
    private List<TransactionsEntity> transactionsEntityList;

    public AccountEntity(int number, String password, String type, double balanca, LocalDate opendata, LocalDate closedata, String accountstatus, ClientsEntity clients) {
        this.number = number;
        this.password = password;
        this.type = type;
        this.balanca = balanca;
        this.opendata = opendata;
        this.closedata = closedata;
        this.accountstatus = accountstatus;
        this.clients = clients;

    }


}
