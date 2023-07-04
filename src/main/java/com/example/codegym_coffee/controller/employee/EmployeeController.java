package com.example.codegym_coffee.controller.employee;


import com.example.codegym_coffee.dto.employee.EmployeeDTO;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.service.employee.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("api/admin/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;






    @GetMapping("")
    public ResponseEntity<Page<Employee>> listEmployee(@RequestParam(value = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Employee> listFeedback = employeeService.showList(pageable);
        if (listFeedback.isEmpty()) {
            return new ResponseEntity<>(listFeedback, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listFeedback, HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<Page<Employee>> findByName(@RequestParam(value = "page", defaultValue = "0") int page, @PathVariable String name) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Employee> listEmployee = employeeService.findByName(name,pageable);
        if (listEmployee.isEmpty()) {
            return new ResponseEntity<>(listEmployee, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }
    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<?> findByPhone(@RequestParam(value = "page", defaultValue = "0") int page, @PathVariable String phoneNumber) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Employee> listEmployee = employeeService.findByPhone(phoneNumber,pageable);
        if (listEmployee.isEmpty()) {
            return new ResponseEntity<>(listEmployee, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }
    @GetMapping("/search/{nameEmployee}&{nameAccount}&{phoneNumber}")
    public ResponseEntity<Page<Employee>> findByEmployee(@RequestParam(value = "page", defaultValue = "0") int page, @PathVariable String nameAccount, @PathVariable String nameEmployee, @PathVariable String phoneNumber) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Employee> listEmployee = employeeService.findByEmployee(nameEmployee,nameAccount,phoneNumber,pageable);
        if (listEmployee.isEmpty    ()) {
            return new ResponseEntity<>(listEmployee, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public void deleteEmployeeById(@PathVariable("id") Integer id) {
        employeeService.deleteByIdEmployee(id);
    }




    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public ResponseEntity<?> createEmployeeWithAccount(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        employeeService.create(employeeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
