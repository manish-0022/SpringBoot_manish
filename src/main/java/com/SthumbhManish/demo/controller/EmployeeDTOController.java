package com.SthumbhManish.demo.controller;

import com.SthumbhManish.demo.DTO.EmployeeRequest;
import com.SthumbhManish.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee1")

public class EmployeeDTOController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/createEmployee1")
    public ResponseEntity<EmployeeRequest> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest){
        EmployeeRequest employeeRequest1 = employeeService.createEmployee(employeeRequest);
        if(employeeRequest1==null){

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(employeeRequest1, HttpStatus.CREATED);
    }




}
