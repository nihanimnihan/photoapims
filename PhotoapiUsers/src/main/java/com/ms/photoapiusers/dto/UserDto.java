package com.ms.photoapiusers.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = -6712493033153510260L;

    private String userId = UUID.randomUUID().toString();
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
}
