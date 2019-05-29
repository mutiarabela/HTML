package com.SpringbootHtmlThymeleaf.HTMLwithThymeleaf.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
public class User {

    @NotBlank(message = "Please input your name here")
    private String name;

    @NotBlank(message = "Please input your place of birth here")
    private String birthplace;

    @NotBlank(message = "Please input your date of birth here")
    private String birthdate;

    @NotBlank(message = "Please input your address here")
    private String address;

    @NotBlank(message = "Email is blank")
    @Email(message = "email format wrong!!!")
    private String email;

    private String gender;
    private String status;
    private String hobby;

}
