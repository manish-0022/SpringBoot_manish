package com.SthumbhManish.demo.service;

import com.SthumbhManish.demo.Model.Employee;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeService {

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
}
