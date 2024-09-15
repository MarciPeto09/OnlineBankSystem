package org.example.transactions;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.account.AccountEntity;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transactions")

public class TransactionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String type;
    private String amount;
    private LocalDate date;

    @ManyToMany
    @JoinTable(
            name = "account_transactions",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    private List<AccountEntity> accountEntityList;

    public TransactionsEntity(String type, String amount, LocalDate date, List<AccountEntity> accountEntityList) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.accountEntityList = accountEntityList;
    }
}


