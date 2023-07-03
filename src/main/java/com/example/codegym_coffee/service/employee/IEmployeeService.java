package com.example.codegym_coffee.service.employee;

import com.example.codegym_coffee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IEmployeeService {
    Page<Employee> showList(org.springframework.data.domain.Pageable pageable);

    Page<Employee> findByEmployee(String name,String account,String phoneNumber,Pageable pageable);


//    void addEmployee(String nameEmployee, Boolean gender, LocalDate dateOfBirth, double salary,
//                     String image, String address,

    Page<Employee> findByName(String name, Pageable pageable);

}
