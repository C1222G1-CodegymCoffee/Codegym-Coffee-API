package com.example.codegym_coffee.service.employee.impl;

import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.model.Position;
import com.example.codegym_coffee.repository.employee.IAccountRepository;
import com.example.codegym_coffee.repository.employee.IEmployeeRepository;
import com.example.codegym_coffee.service.account.IAccountService;
import com.example.codegym_coffee.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;


    @Override
    public Page<Employee> showList(Pageable pageable) {
        Pageable validPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        return iEmployeeRepository.showListEmployee(validPageable);
    }

    @Override
    public Page<Employee> findByEmployee(String name, String account, String phoneNumber,Pageable pageable) {
        return iEmployeeRepository.findByAll(name,account,phoneNumber,pageable);
    }

//    @Override
//    public Page<Employee> findByEmployee(String name, Account account, String phoneNumber) {
//        return iEmployeeRepository.showListByEmployee(name,account,phoneNumber);
//    }




//    @Transactional
//    @Override
//    public void addEmployee(String nameEmployee, Boolean gender, LocalDate dateOfBirth, double salary,
//                            String image, String address,
//                            String phoneNumber, String email, Position position,Account account) {
//        iEmployeeRepository.addEmployee(nameEmployee,gender, dateOfBirth, salary, image, address, phoneNumber, email, position,account);
//        Employee employee = findByPhone(phoneNumber);
//        Account account = iAccountService.findByNameAccount(account)
//
//    }

    @Override
    public Page<Employee> findByName(String name, Pageable pageable) {
        return iEmployeeRepository.findByName(name,pageable);
    }

//    @Override
//    public Employee findByPhone(String phone) {
//        return iEmployeeRepository.findByPhone(phone);
//    }


}
