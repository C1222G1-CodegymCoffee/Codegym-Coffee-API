package com.example.codegym_coffee.service.employee.impl;

import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.model.Position;
import com.example.codegym_coffee.repository.employee.IEmployeeRepository;
import com.example.codegym_coffee.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public List<Employee> showList() {
        return iEmployeeRepository.showListEmployee();
    }
//    public Page<EmployeeDTO> findAll(String name , Pageable pageable ) {
//        Page<Employee> employeePage = iEmployeeRepository.findCustomerByCustomerContaining(name, pageable);
//        List<EmployeeDTO> customerList = new ArrayList<>();
//        EmployeeDTO employeeDTO;
//        for (Employee employee : employeePage) {
//            employeeDTO = new EmployeeDTO();
//            employee.setCustomerType(customerTypeService.findById(customer.getCustomerType().getId().intValue()));
//            customerDTO.setCustomerType(new CustomerType());
//            BeanUtils.copyProperties(customer.getCustomerType(), customerDTO.getCustomerType());
//            BeanUtils.copyProperties(customer, customerDTO);
//            customerList.add(customerDTO);
//        }
//        return new PageImpl<>(customerList, pageable, employeePage.getTotalElements());





    @Override
    public void addEmployee(String nameEmployee, Boolean gender, LocalDate dateOfBirth, double salary,
                            String image, String address,
                            String phoneNumber, String email, Position position, Account account) {
        iEmployeeRepository.addEmployee(nameEmployee,gender, dateOfBirth, salary, image, address, phoneNumber, email, position, account);
    }


}
