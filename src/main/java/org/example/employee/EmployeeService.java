package org.example.employee;

import java.util.List;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void add(EmployeeEntity employee){
        employeeRepository.add(employee);
    }

    public void remove(int id){
    employeeRepository.remove(id);
}


    public EmployeeEntity findById(int id){
       return  employeeRepository.findById(id);
    }

    public void update(EmployeeEntity object, int id) {
        employeeRepository.update(object, id);
    }

    public List<EmployeeEntity> findAll() {
        return  employeeRepository.findAll();
    }
}
