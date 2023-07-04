package com.example.codegym_coffee.service.employee.impl;

import com.example.codegym_coffee.dto.employee.EmployeeDTO;
import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.repository.employee.IAccountRepository;
import com.example.codegym_coffee.repository.employee.IEmployeeRepository;
import com.example.codegym_coffee.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Autowired
    private IAccountRepository iAccountRepository;
    private PasswordEncoder passwordEncoder;


    @Override
    public Page<Employee> showList(Pageable pageable) {
        Pageable validPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        return iEmployeeRepository.showListEmployee(validPageable);
    }

    @Override
    public Page<Employee> findByEmployee(String name, String account, String phoneNumber, Pageable pageable) {
        return iEmployeeRepository.findByAll(name, account, phoneNumber, pageable);
    }

    @Override
    public Page<Employee> findByName(String name, Pageable pageable) {
        return iEmployeeRepository.findByName(name, pageable);
    }

    @Override
    public Page<Employee> findByPhone(String phone, Pageable pageable) {
        return iEmployeeRepository.findByPhone(phone,pageable);
    }


    @Override
    public void create(EmployeeDTO employeeDTO) {
        iAccountRepository.createAccount(employeeDTO.getAccount().getNameAccount(),
                passwordEncoder.encode("12345678"));
        Account account = iAccountRepository
                .findByName(employeeDTO.getAccount().getNameAccount());
        Employee employee = new Employee();
        employee.setAccount(account);
        BeanUtils.copyProperties(employeeDTO, employee);
        iEmployeeRepository.saveEmployee(
                employee.getNameEmployee(),
                employee.getGender(),
                employee.getDateOfBirth(),
                employee.getSalary(),
                employee.getImage(),
                employee.getAddress(),
                employee.getPhoneNumber(),
                employee.getEmail(),
                employee.getPosition(),
                account.getIdAccount());
    }
}
