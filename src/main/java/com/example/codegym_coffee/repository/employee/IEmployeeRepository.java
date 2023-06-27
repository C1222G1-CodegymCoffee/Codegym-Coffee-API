package com.example.codegym_coffee.repository.employee;

import com.example.codegym_coffee.dto.employee.EmployeeDTO;
import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * Creator: THangHA
 * Date Create: 27/06/2023
 * Function : Add new employee to database
 */

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from employee where nameEmployee like %:nameEmployee% and account like %:account% and phoneNumber like %:phoneNumber% ", nativeQuery = true)
    List<Employee> showListByEmployee(String nameEmployee, Account account, String phoneNumber);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO employee (nameEmployee, gender, dateOfBirth, salary, image, address, phoneNumber, email, position, account) "
            + "VALUES (:nameEmployee, :gender, :dateOfBirth, :salary, :image, :address, :phoneNumber, :email, :position, :account)",
            nativeQuery = true)
    EmployeeDTO addEmployee(
            @Param("nameEmployee") String nameEmployee,
            @Param("gender") boolean gender,
            @Param("dateOfBirth") LocalDate dateOfBirth,
            @Param("salary") double salary,
            @Param("image") String image,
            @Param("address") String address,
            @Param("phoneNumber") String phoneNumber,
            @Param("email") String email,
            @Param("position") Position position,
            @Param("account") Account account
    );



}
