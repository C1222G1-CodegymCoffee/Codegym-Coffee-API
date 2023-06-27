package com.example.codegym_coffee.service.account;

import com.example.codegym_coffee.model.Employee;

import java.time.LocalDate;

public interface IAccountInformationService {
    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use findbyId method to find out personal information
     * @param idEmployee
     * @return
     */
    Employee findByEmployeeId(Integer idEmployee);

    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use the update method to update personal information
     * @param nameEmployee
     * @param gender
     * @param dateOfBirth
     * @param phoneNumber
     * @param address
     * @param idPosition
     */
    void updateEmployee(String nameEmployee, Boolean gender, LocalDate dateOfBirth,String phoneNumber,String address,Integer idPosition,String image,double salary);
}
