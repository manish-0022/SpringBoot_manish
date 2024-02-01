package com.SthumbhManish.demo.Repositry;

import com.SthumbhManish.demo.Entity.EmployeeEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmployeeRepository {
    public void save(EmployeeEntity employee) {
        //System.out.println("Employee is :" +employee);
        log.info("Employee is: {}",employee);   //for printing info as log
       // log.error();                          //for printing error as log
    }
}
