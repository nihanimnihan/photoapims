package com.ms.photoapiusers.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateUserRequestModel {

    @NotNull(message = "First name can not be null")
    @Size(min = 2, message = "First must can not be less than 2 characters")
    private String firstName;
    @NotNull(message = "Last name can not be null")
    @Size(min = 2, message = "Last name must not be less than 2 characters")
    private String lastName;
    @NotNull(message = "Email can not be null")
    @Email
    private String email;
    @NotNull(message = "Password can not be null")
    @Size(min = 8, max = 16, message = "Password must be greater than 8 characters, less than 16 characters")
    private String password;

}
