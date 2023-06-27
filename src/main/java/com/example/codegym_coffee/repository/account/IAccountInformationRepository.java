package com.example.codegym_coffee.repository.account;

import com.example.codegym_coffee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface IAccountInformationRepository extends JpaRepository<Employee, Integer> {
    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use findbyId method to find out personal information
     *
     * @param idEmployee
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "select * from employee where id_employee=:idEmployee", nativeQuery = true)
    Employee findByEmployeeId(@Param("idEmployee") Integer idEmployee);

    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use the update method to update personal information
     *
     * @param nameEmployee
     * @param gender
     * @param phoneNumber
     * @param dateOfBirth
     * @param salary
     * @param idPosition
     * @param address
     */
    @Modifying
    @Transactional
    @Query(value = "update employee set name_employee=:nameEmployee,gender=:gender,phone_number=:phoneNumber,salary=:salary,date_of_birth=:dateOfBirth,image=:image,id_position=:idPosition, address=:address where id_employee=:idEmployee", nativeQuery = true)
    void updateEmployee(@Param("nameEmployee") String nameEmployee,
                        @Param("gender") Boolean gender,
                        @Param("phoneNumber") String phoneNumber,
                        @Param("dateOfBirth") LocalDate dateOfBirth,
                        @Param("salary") double salary,
                        @Param("idPosition") Integer idPosition,
                        @Param("address") String address,
                        @Param("image") String image);

}
