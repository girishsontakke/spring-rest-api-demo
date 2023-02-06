package com.girishms.springrestdemo.controllers;

import com.girishms.springrestdemo.models.Employee;
import com.girishms.springrestdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // @Controller + @ResponseBody
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "")
    private ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getEmployeeList());
    }

    @PostMapping(value = "")
    private ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<Employee> getEmployeeDetail(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));

    }

    @PutMapping(value = "/{id}")
    private ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK );
    }

    @DeleteMapping(value = "/{id}")
    private ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
