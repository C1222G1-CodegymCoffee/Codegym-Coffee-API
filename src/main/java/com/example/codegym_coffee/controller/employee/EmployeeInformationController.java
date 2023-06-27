package com.example.codegym_coffee.controller.employee;

import com.example.codegym_coffee.dto.employee.EmployeeUpdateDTO;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.service.employee.IEmployeeInformationService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeInformationController {
    @Autowired
    private IEmployeeInformationService iEmployeeInformationService;

    /**
     * Author:QuynhHTN
     * Date create: 27/06/2023
     * Function: use findByNameAccount method to find out personal information
     * @param nameAccount
     * @return
     */
    @GetMapping("/detail")
    public ResponseEntity<Employee> findByNameAccount(@RequestParam(required = false, defaultValue = "") String nameAccount) {
        Employee employee = iEmployeeInformationService.findByNameAccount(nameAccount);
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
     * @param employeeUpdateDTO
     * @param bindingResult
     * @return
     */
    @PatchMapping("/update")
    public ResponseEntity<?> updateEmployee( @Validated @RequestBody EmployeeUpdateDTO employeeUpdateDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> err = bindingResult.getFieldErrors();
            for (FieldError error : err) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        int age = employeeUpdateDTO.getAge();
        if (age < 15) {
            return new ResponseEntity<>("Người dùng phải từ 15 tuổi trở lên",HttpStatus.BAD_REQUEST);
        }
        iEmployeeInformationService.updateEmployee(employeeUpdateDTO);
        return new ResponseEntity<>("Chỉnh sửa thành công",HttpStatus.OK);
    }
}
