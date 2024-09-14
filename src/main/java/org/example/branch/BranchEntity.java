package org.example.branch;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "branch")

public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int branchId;

    public BranchEntity(String name, int code, String address) {
        this.name = name;
        this.code = code;
        this.address = address;
    }

    private String name;
    private int code;
    private String address;
}
