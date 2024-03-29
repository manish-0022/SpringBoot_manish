package com.SthumbhManish.demo.service;

import com.SthumbhManish.demo.DTO.UserRequestDTO;
import com.SthumbhManish.demo.DTO.UserResponseDTo;
import com.SthumbhManish.demo.Entity.UserEntity;
import com.SthumbhManish.demo.Repositry.UserManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserManagementService {
    @Autowired
    private UserManagementRepository userManagementRepository;
    public UserResponseDTo  createUser(UserRequestDTO userRequestDTO) {

        UserEntity userEntity = new UserEntity();

        userEntity.setName(userRequestDTO.getName());
        userEntity.setAddress(userRequestDTO.getAddress());
        userEntity.setLastName(userRequestDTO.getLastName());
        userEntity.setMobileNumber(userRequestDTO.getMobileNumber());

       UserEntity responseEntity =  userManagementRepository.save(userEntity);

       UserResponseDTo userResponseDTo = new UserResponseDTo();

        userResponseDTo.setId(responseEntity.getId());
        userResponseDTo.setName(responseEntity.getName());
        userResponseDTo.setLastName(responseEntity.getLastName());
        userResponseDTo.setAddress(responseEntity.getAddress());
        userResponseDTo.setMobileNumber(responseEntity.getMobileNumber());

        return userResponseDTo;

    }


    public List<UserEntity> getUsers() {
        return userManagementRepository.findAll();
    }


    public UserEntity getUsersbyID(Long userID) {
        Optional<UserEntity>  userEntity = userManagementRepository.findById(userID);
        if(!userEntity.isEmpty()) {
            return userEntity.get();
        }
        return null;
    }
}
