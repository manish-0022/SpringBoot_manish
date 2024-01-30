package com.SthumbhManish.demo.controllerExample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @GetMapping
    public String getString(){
        return "Hello World";
    }

    @PostMapping(value = "/CreateEmployee")
    public Employee createemployee(@RequestBody Employee employee){
        return employee;
    }


}
