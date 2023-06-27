package com.example.codegym_coffee.service.employee.impl;

import com.example.codegym_coffee.dto.employee.EmployeeDTO;
import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.model.Position;
import com.example.codegym_coffee.repository.employee.IEmployeeRepository;
import com.example.codegym_coffee.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
@Autowired
private IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> showList(String nameEmployee, Account account,String phoneNumber) {
        return iEmployeeRepository.showListByEmployee(nameEmployee,account,phoneNumber);
    }

    @Override
    public void addEmployee(Boolean gender, LocalDate dateOfBirth, double salary,
                            String image, String nameEmployee, String address,
                            String phoneNumber, String email, Position position, Account account) {
        iEmployeeRepository.addEmployee(nameEmployee,gender,dateOfBirth,salary,image,address,phoneNumber,email,position,account);
    }


}
