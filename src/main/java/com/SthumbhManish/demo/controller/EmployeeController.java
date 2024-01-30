package com.SthumbhManish.demo.controller;

import com.SthumbhManish.demo.Model.Employee;
import com.SthumbhManish.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

   /* @PostMapping(value ="/createEmployee")*/
    @PostMapping(path = {"/createEmployee", "/createEmployee1"})
    public Employee createEmployee(@RequestBody Employee employee){
        return employee;
    }

    public ResponseEntity<Employee> createEmployeresponseEntity(@RequestBody Employee employee){
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping(value = "/getEmployee")
    public Employee getEmployee(){
        return new Employee("rohit","0-101-1990","delhi","Emp002");
    }

    @DeleteMapping(value="/deleteEmployee")
    public Employee deleteEmployee() {
        return new Employee("rohit","0-101-1990","delhi","Emp002");
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
    @PutMapping(value = "/updateEmployee")
    public Employee updateEmployee() {
        return new Employee("rohit","0-101-1990","delhi","Emp002");
    }



//get Employees on behalf of empId

   /* @GetMapping(value = "/getEmp/{emp_id}")
    public ResponseEntity<List<Employee>> getEmployeeDetails(@PathVariable("emp_id") String empId){
        List<Employee> employeeList = employeeService.getEmployee(empId);
       return new ResponseEntity<>(employeeList,HttpStatus.OK);

    }
*/
    //get Employees on behalf of empId and name

    /*@GetMapping(value = "/getEmp/{emp_id}/{emp_name}")
    public ResponseEntity<List<Employee>> getEmployeeDetails(@PathVariable(name = "emp_id") String empId,
                                                             @PathVariable(name = "emp_name") String empName){
        List<Employee> employeeList = employeeService.getEmployee(empId,empName);
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }*/

//getEmployee based on Param

    @GetMapping(value = "/getEmp")
    public ResponseEntity<List<Employee>> getEmployeeDetails(@RequestParam(name = "emp_id",required = false, defaultValue = "EMP001") String empId,
                                                             @RequestParam(name = "emp_name",required = false) String empName){
        List<Employee> employeeList = employeeService.getEmployee(empId,empName);
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    //gt=etEmployee based on header














}
