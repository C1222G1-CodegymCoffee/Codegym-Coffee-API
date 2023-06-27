package com.example.codegym_coffee.service.employee;

import com.example.codegym_coffee.dto.employee.EmployeeDTO;
import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.model.Position;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IEmployeeService {
    List<Employee> showList(String nameEmployee, Account account,String phoneNumber);
    void addEmployee(Boolean gender, LocalDate dateOfBirth, double salary,
                     String image, String nameEmployee, String address,
                     String phoneNumber, String email, Position position, Account account);
}
