package com.example.codegym_coffee.service.account.impl;

import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.repository.account.IAccountInformationRepository;
import com.example.codegym_coffee.service.account.IAccountInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AccountInformationService implements IAccountInformationService {
    @Autowired
    IAccountInformationRepository iAccountInformationRepository;

    @Override
    public Employee findByEmployeeId(Integer idEmployee) {
        return iAccountInformationRepository.findByEmployeeId(idEmployee);
    }

    @Override
    public void updateEmployee(String nameEmployee, Boolean gender, LocalDate dateOfBirth, String phoneNumber, String address, Integer idPosition, String image, double salary) {
        iAccountInformationRepository.updateEmployee(nameEmployee,gender,phoneNumber,dateOfBirth, salary,idPosition,address,image);
    }
}
