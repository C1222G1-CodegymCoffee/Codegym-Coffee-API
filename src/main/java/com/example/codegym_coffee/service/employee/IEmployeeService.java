package com.example.codegym_coffee.service.employee;

import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface IEmployeeService {
    Page<Employee> showList(org.springframework.data.domain.Pageable pageable);

    Page<Employee> findByEmployee(String name,String account,String phoneNumber,Pageable pageable);


//    void addEmployee(String nameEmployee, Boolean gender, LocalDate dateOfBirth, double salary,
//                     String image, String address,
//                     String phoneNumber, String email, Position position);

    Page<Employee> findByName(String name, Pageable pageable);

//    Employee findByPhone(String phone);
}
