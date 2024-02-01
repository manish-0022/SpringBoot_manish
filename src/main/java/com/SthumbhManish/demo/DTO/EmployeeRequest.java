package com.SthumbhManish.demo.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeRequest {
    //@JsonProperty("employee_name")  accept only employee_name
    @JsonAlias("employee_name")  //accept both name or employee_name
    @NotBlank(message = "name should not be null or empty")
    @Size(max = 255, message = "name size should not be maximum 255")
    private String name;  //255

    @JsonAlias("employee_dob")
    @NotNull(message = "dob should not be null")
    @Size(max = 255, message = "dob size should not be maximum 10")
    private String dob;  //10


    @Size(max = 255, message = "address size should not be maximum 100")
    private String address;  //100

    private  String empId;

   @Digits(integer = 10,fraction = 2, message ="fraction should not be 2")
   private Double value;




}
