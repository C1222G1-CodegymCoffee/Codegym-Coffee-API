package com.example.codegym_coffee.service.employee;

import com.example.codegym_coffee.dto.employee.EmployeeDTO;
import com.example.codegym_coffee.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


public interface IEmployeeService {
    Page<Employee> showList(org.springframework.data.domain.Pageable pageable);

    Page<Employee> findByEmployee(String name,String account,String phoneNumber,Pageable pageable);

    void deleteByIdEmployee(Integer idEmployee);

    Page<Employee> findByName(String name, Pageable pageable);
    Page<Employee> findByPhone(String phone, Pageable pageable);


    void create(EmployeeDTO employeeDTO);
}
