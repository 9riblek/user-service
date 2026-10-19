package com.qirblek.userservice.dto;

import com.qirblek.userservice.enums.Role;
import lombok.Data;

import java.util.UUID;

@Data
public class UserRegisterDTO {
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String phone;
    private Role role;
    private String city;
    private String bio;
}
