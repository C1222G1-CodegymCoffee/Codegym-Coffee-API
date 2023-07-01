package com.example.codegym_coffee.repository.employee;

import com.example.codegym_coffee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;

public interface IEmployeeInformationRepository extends JpaRepository<Employee, Integer> {
    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use findByNameAccount method to find out personal information
     *
     * @param nameAccount
     * @return
     */
    @Query(value = "select * from employee e join account a on e.id_account = a.id_account where a.name_account = :nameAccount", nativeQuery = true)
    Employee findByNameAccount(@Param("nameAccount") String nameAccount);
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
    @Query(value = "update employee set name_employee=:nameEmployee,gender=:gender,phone_number=:phoneNumber,salary=:salary,date_of_birth=:dateOfBirth,image=:image,id_position=:idPosition, address=:address where id_employee = :idEmployee", nativeQuery = true)
    void updateEmployee(@Param("nameEmployee") String nameEmployee,
                        @Param("gender") Boolean gender,
                        @Param("phoneNumber") String phoneNumber,
                        @Param("dateOfBirth") LocalDate dateOfBirth,
                        @Param("salary") Double salary,
                        @Param("idPosition") Integer idPosition,
                        @Param("address") String address,
                        @Param("image") String image,
                        @Param("idEmployee") Integer idEmployee);

//    @Modifying
//    @Transactional
//    @Query(value = "UPDATE account SET password = :newPassword WHERE id_account = :id",nativeQuery = true)
//    void updatePassword(@Param("newPassword")String newPassword,@Param("id")Integer id);
        Boolean existsByEmail(String email);
}
