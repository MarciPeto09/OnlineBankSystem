package org.example.clients;


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
@Table(name = "clients")
public class ClientsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String email;
    private long phoneNumber;
    private String address;

    @OneToMany(mappedBy = "clients", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccountEntity> accountEntityList;

    public ClientsEntity(String name, String surname, LocalDate dateOfBirth, String email, long phoneNumber, String address) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}


