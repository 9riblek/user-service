package com.qirblek.userservice.dto;

import com.qirblek.userservice.enums.Role;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserResponseDTO {
    private UUID id;
    private String first_name;
    private String last_name;
    private String username;
    private String phone;
    private Role role;
    private String city;
    private String bio;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
