package com.example.codegym_coffee.service.employee.impl;

import com.example.codegym_coffee.dto.employee.EmployeeUpdateDTO;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.model.Position;
import com.example.codegym_coffee.repository.employee.IEmployeeInformationRepository;
import com.example.codegym_coffee.service.employee.IEmployeeInformationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeInformationService implements IEmployeeInformationService {
    @Autowired
    IEmployeeInformationRepository iEmployeeInformationRepository;

    
    @Override
    public Employee findByNameAccount(String nameAccount) {
        return iEmployeeInformationRepository.findByNameAccount(nameAccount);
    }

    
    @Override
    public void updateEmployee(Employee employee) {
        iEmployeeInformationRepository.updateEmployee(
                employee.getNameEmployee(),
                employee.getGender(),
                employee.getPhoneNumber(),
                employee.getDateOfBirth(),
                employee.getSalary(),
                employee.getPosition().getIdPosition(),
                employee.getAddress(),
                employee.getImage(),
                employee.getIdEmployee());
    }

    @Override
    public Boolean existsByEmail(String email) {
        return iEmployeeInformationRepository.existsByEmail(email);
    }
}
