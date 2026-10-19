package com.qirblek.userservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserRegisterResponseDTO {
    private UUID id;
    private String username;
    private String role;
}
