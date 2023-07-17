package com.example.codegym_coffee.service.employee;

import com.example.codegym_coffee.dto.employee.EmployeeUpdateDTO;
import com.example.codegym_coffee.model.Employee;

public interface IEmployeeInformationService {
    
    Employee findByNameAccount(String nameAccount);

   
    void updateEmployee(Employee employee);

    Boolean existsByEmail(String email);
}
