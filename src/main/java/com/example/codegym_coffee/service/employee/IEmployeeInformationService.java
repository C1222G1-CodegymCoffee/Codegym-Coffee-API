package com.example.codegym_coffee.service.employee;

import com.example.codegym_coffee.dto.employee.EmployeeUpdateDTO;
import com.example.codegym_coffee.model.Employee;

public interface IEmployeeInformationService {
    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use findByNameAccount method to find out personal information
     * @param nameAccount
     * @return
     */
    Employee findByNameAccount(String nameAccount);

    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use the update method to update personal information
     * @param employee
     */
    void updateEmployee(Employee employee);

    Boolean existsByEmail(String email);
}
