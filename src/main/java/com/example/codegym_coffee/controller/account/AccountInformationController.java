package com.example.codegym_coffee.controller.account;

import com.example.codegym_coffee.dto.account.EmployeeUpdateDTO;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.service.account.IAccountInformationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class AccountInformationController {
    @Autowired
    private IAccountInformationService iAccountInformationService;

    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use findbyId method to find out personal information
     * @param idEmployee
     * @return
     */
    @GetMapping("/{idEmployee}")
    public ResponseEntity<Employee> findByEmployeeId(@PathVariable Integer idEmployee) {
        Employee employee = iAccountInformationService.findByEmployeeId(idEmployee);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function:update employee data if ID is not found then return HttpStatus.NOT_FOUND,
      if found ID then edit data in DB and return HttpStatus.OK
     * @param idEmployee
     * @param employeeUpdateDTO
     * @param bindingResult
     * @return
     */
    @PatchMapping("/update/{idEmployee}")
    public ResponseEntity<?> updateEmployee(@PathVariable("idEmployee") Integer idEmployee, @Validated @RequestBody EmployeeUpdateDTO employeeUpdateDTO, BindingResult bindingResult) {
        new EmployeeUpdateDTO().validate(employeeUpdateDTO, bindingResult);
        employeeUpdateDTO.setIdEmployee(idEmployee);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Employee employee = iAccountInformationService.findByEmployeeId(idEmployee);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            iAccountInformationService.updateEmployee(employeeUpdateDTO.getNameEmployee(), employeeUpdateDTO.getGender(), employeeUpdateDTO.getDateOfBirth(), employeeUpdateDTO.getPhoneNumber(), employeeUpdateDTO.getAddress(), employeeUpdateDTO.getPositionDTO().getIdPosition(), employeeUpdateDTO.getImage(), employeeUpdateDTO.getSalary());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
