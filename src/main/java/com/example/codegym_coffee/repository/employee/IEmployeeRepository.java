package com.example.codegym_coffee.repository.employee;

import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Creator: THangHA
 * Date Create: 27/06/2023
 * Function : Add new employee to database
 */

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

//    @Query(value = "select * from employee ", nativeQuery = true)
//    List<Employee> showListByEmployee(String nameEmployee, Account account, String phoneNumber);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO employee ( name_employee,gender,date_of_birth, salary, image, address, phone_number, email, id_position, id_account) "
            + "VALUES (:name_employee, :gender, :date_of_birth, :salary, :image, :address, :phone_number, :email, :id_position, :id_account)",
            nativeQuery = true)
    void addEmployee(
            @Param("name_employee") String nameEmployee,
            @Param("gender") Boolean gender,
            @Param("date_of_birth") LocalDate dateOfBirth,
            @Param("salary") double salary,
            @Param("image") String image,
            @Param("address") String address,
            @Param("phone_number") String phoneNumber,
            @Param("email") String email,
            @Param("id_position") Position positionDTO,
            @Param("id_account") Account account
    );

    @Query(value = "select * from employee",nativeQuery = true)
    Page<Employee> showListEmployee(Pageable pageable);
}
