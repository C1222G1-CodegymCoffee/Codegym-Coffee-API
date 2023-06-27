package com.example.codegym_coffee.controller.employee;


import com.example.codegym_coffee.dto.employee.EmployeeDTO;
import com.example.codegym_coffee.model.Account;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.service.employee.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("home/admin/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("")
    public List<Employee> list( @RequestParam(required = false, defaultValue = "") String nameEmployee, Account account,String phoneNumber) {
        return employeeService.showList(nameEmployee,account,phoneNumber);
    }

    @PostMapping("")
    public ResponseEntity<?> saveEmployee(@Validated @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            employeeService.addEmployee(employeeDTO.getGender(),employeeDTO.getDateOfBirth(),employeeDTO.getSalary(),employeeDTO.getNameEmployee(),employeeDTO.getImage(),employeeDTO.getAddress(),employeeDTO.getPhoneNumber(),employeeDTO.getEmail(),employeeDTO.getPosition(),employeeDTO.getAccount());
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(),    error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
