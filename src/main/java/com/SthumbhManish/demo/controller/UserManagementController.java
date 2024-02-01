package com.SthumbhManish.demo.controller;

import com.SthumbhManish.demo.DTO.UserRequestDTO;
import com.SthumbhManish.demo.DTO.UserResponseDTo;
import com.SthumbhManish.demo.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping("/createUser")

    public ResponseEntity<UserResponseDTo> createUser(@RequestBody UserRequestDTO userRequestDTO){

        UserResponseDTo userResponseDTo = userManagementService.createUser(userRequestDTO);
        if(userResponseDTo==null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userResponseDTo, HttpStatus.CREATED);
    }




}
