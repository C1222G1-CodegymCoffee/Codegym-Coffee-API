package com.example.codegym_coffee.controller.employee;


import com.example.codegym_coffee.model.Employee;
import com.example.codegym_coffee.service.employee.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("home/admin/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;



//    @GetMapping("")
//    public Page<Employee> showList(Pageable pageable) {
//        return employeeService.showList( pageable);
//    }

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
    @GetMapping("/search/searchEmployee")
    public ResponseEntity<Page<Employee>> findByEmployee(@RequestParam(value = "page", defaultValue = "0") int page, @PathVariable String nameEmployee, @PathVariable String nameAccount, @PathVariable String phoneNumber, @PathVariable String employee) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Employee> listEmployee = employeeService.findByEmployee(nameEmployee,nameAccount,phoneNumber,pageable);
        if (listEmployee.isEmpty()) {
            return new ResponseEntity<>(listEmployee, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }



//    @GetMapping("/list-employee")
//    public Page<Employee> findAllEmployee(
//            @PageableDefault(size = 2,sort = "id", direction = Sort.Direction.DESC)Pageable pageable,
//            @RequestParam(required = false, defaultValue = "") String name,Account account ,String phoneNumber) {


//    @PostMapping("")
//    public ResponseEntity<?> saveEmployee(@Validated @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
//        if (!bindingResult.hasErrors()) {
//            employeeService.addEmployee(employeeDTO.getNameEmployee()
//                    ,employeeDTO.getGender(),employeeDTO.getDateOfBirth(),employeeDTO.getSalary(),
//                    employeeDTO.getImage(),employeeDTO.getAddress(),employeeDTO.getPhoneNumber(),employeeDTO.getEmail(),
//                    employeeDTO.getPosition());
//        } else {
//            Map<String, String> map = new LinkedHashMap<>();
//            List<FieldError> errors = bindingResult.getFieldErrors();
//            for (FieldError error : errors) {
//                if (!map.containsKey(error.getField())) {
//                    map.put(error.getField(),error.getDefaultMessage());
//                }
//            }
//            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

}
