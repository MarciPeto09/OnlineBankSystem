package org.example.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.branch.BranchEntity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String position;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private BranchEntity branch;

    public EmployeeEntity(String position, BranchEntity branch) {
        this.position = position;
        this.branch = branch;
    }
}
