package com.SthumbhManish.demo.service;

import com.SthumbhManish.demo.DTO.EmployeeRequest;
import com.SthumbhManish.demo.Entity.EmployeeEntity;
import com.SthumbhManish.demo.Model.Employee;
import com.SthumbhManish.demo.Repositry.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/*@Component*/
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployee(String empId,String name) {
        List<Employee> employeeList = getEmp().stream()
                .filter(i -> i.getEmpId().equals(empId))
                .collect(Collectors.toList());

        if (employeeList.isEmpty()) {
            employeeList = getEmp().stream()
                    .filter(i -> i.getName().equals(name))
                    .collect(Collectors.toList());
        }
        return employeeList;
    }



    private List<Employee>  getEmp(){
        Employee employee1 = new Employee("Aman", "21-10,1991", "Mumbai", "EMP001");
        Employee employee2 = new Employee("Rahul", "21-10,1995", "Mumbai", "EMP002");
        Employee employee3 = new Employee("Amit", "21-10,1990", "Mumbai", "EMP003");

      /*  return List.of(employee1,employee2,employee3);*/
        return Arrays.asList(employee1,employee2,employee3);

    }
        public EmployeeRequest createEmployee(EmployeeRequest employeeRequest) {

        if(employeeRequest.getName().length()>255){
            return null;
        }

            if(employeeRequest.getDob().length()>10){
                return null;
            }
            String uuid = String.valueOf(UUID.randomUUID());
            EmployeeEntity employeeEntity = new EmployeeEntity(uuid,
                    employeeRequest.getName(),
                    employeeRequest.getDob(), employeeRequest.getAddress(), employeeRequest.getAddress(), "oajsoso", "988765343");

            employeeRepository.save(employeeEntity);
            employeeRequest.setEmpId(uuid);
            return employeeRequest;

        }
}



