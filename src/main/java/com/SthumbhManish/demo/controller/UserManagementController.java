package com.SthumbhManish.demo.controller;

import com.SthumbhManish.demo.DTO.UserRequestDTO;
import com.SthumbhManish.demo.DTO.UserResponseDTo;
import com.SthumbhManish.demo.Entity.UserEntity;
import com.SthumbhManish.demo.Model.CustomResponseModel;
import com.SthumbhManish.demo.Model.Metadata;
import com.SthumbhManish.demo.Model.ResourceData;
import com.SthumbhManish.demo.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping("/createUser")

   /* //create user based on Dto

    public ResponseEntity<UserResponseDTo> createUser(@RequestBody UserRequestDTO userRequestDTO){

        UserResponseDTo userResponseDTo = userManagementService.createUser(userRequestDTO);
        if(userResponseDTo==null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userResponseDTo, HttpStatus.CREATED);
    }*/

    //create user based on CustomResponseModel in customise way

    public ResponseEntity<CustomResponseModel> createUser(@RequestBody UserRequestDTO userRequestDTO){

        UserResponseDTo userResponseDTo = userManagementService.createUser(userRequestDTO);
        if(userResponseDTo==null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Metadata metadata = new Metadata();


        metadata.setCode("201");
        metadata.setMessage("Success");
        metadata.setVersion("2.0");
        metadata.setStatus("Ok");

        ResourceData resourceData = new ResourceData();
        resourceData.setData(userRequestDTO);

        CustomResponseModel customResponseModel = new CustomResponseModel();
        customResponseModel.setMetadata(metadata);
        customResponseModel.setResourceData(resourceData);

        return new ResponseEntity<>(customResponseModel,HttpStatus.CREATED);
    }

    //get all user details from database

   /* @GetMapping("/getuser_details")

    public ResponseEntity<CustomResponseModel> getUsers(){

       List<UserEntity> userEntityList = userManagementService.getUsers();
        Metadata metadata = new Metadata();

        metadata.setCode("201");
        metadata.setMessage("Success");
        metadata.setVersion("2.0");
        metadata.setStatus("Ok");

        ResourceData resourceData = new ResourceData();
        resourceData.setData(userEntityList);

        CustomResponseModel customResponseModel = new CustomResponseModel();
        customResponseModel.setMetadata(metadata);
        customResponseModel.setResourceData(resourceData);
        return new ResponseEntity<>(customResponseModel,HttpStatus.CREATED);

    }*/

    //get users from database on user_id based;
    @GetMapping("/getuser_details/{id}")
    public ResponseEntity<CustomResponseModel> getUsersbyID(@PathVariable (name = "id") Long UserID ){

        UserEntity userEntity = userManagementService.getUsersbyID(UserID);
        String Message = "Success";

        if(userEntity ==null){
            Message = "user is not available with: "+UserID;

        }
        Metadata metadata = new Metadata();

        metadata.setCode("201");
        metadata.setMessage(Message);
        metadata.setVersion("2.0");
        metadata.setStatus("Ok");

        ResourceData resourceData = new ResourceData();
        resourceData.setData(userEntity);

        CustomResponseModel customResponseModel = new CustomResponseModel();
        customResponseModel.setMetadata(metadata);
        customResponseModel.setResourceData(resourceData);
        return new ResponseEntity<>(customResponseModel,HttpStatus.CREATED);

    }







}
