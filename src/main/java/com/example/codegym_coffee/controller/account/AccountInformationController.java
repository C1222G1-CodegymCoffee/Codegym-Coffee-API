package com.example.codegym_coffee.controller.account;

import com.example.codegym_coffee.dto.account.EmployeeUpdateDTO;
import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.service.account.IAccountInformationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class AccountInformationController {
    @Autowired
    private IAccountInformationService iAccountInformationService;
    @GetMapping("/{idEmployee}")
    public ResponseEntity<Employee>findByEmployeeId(@PathVariable Integer idEmployee){
        Employee employee= iAccountInformationService.findByEmployeeId(idEmployee);
        if(employee==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
@PatchMapping("/update/{idEmployee}")
public ResponseEntity<?> updateEmployee(HttpServletRequest request, @Validated @RequestBody EmployeeUpdateDTO employeeUpdateDTO, BindingResult bindingResult){
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
        return new ResponseEntity<>(new ResponseMessage("Người dùng phải từ 15 tuổi trở lên"),HttpStatus.BAD_REQUEST);
    }
Employee employee= iAccountInformationService.findByEmployeeId(

}
}
