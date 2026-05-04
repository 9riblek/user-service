package com.qirblek.userservice.mapper;

import com.qirblek.userservice.dto.UserRegisterDTO;
import com.qirblek.userservice.dto.UserResponseDTO;
import com.qirblek.userservice.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserMapper {

    public User toEntity(UserRegisterDTO dto) {
        User user = new User();
        user.setFirst_name(dto.getFirst_name());
        user.setLast_name(dto.getLast_name());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setCity(dto.getCity());
        user.setBio(dto.getBio());
        user.setRole(dto.getRole());
        return user;
    }

    public UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setFirst_name(user.getFirst_name());
        dto.setLast_name(user.getLast_name());
        dto.setPhone(user.getPhone());
        dto.setCity(user.getCity());
        dto.setBio(user.getBio());
        dto.setRole(user.getRole());
        return dto;
    }

    public List<UserResponseDTO> toDTO(List<User> users) {
        List<UserResponseDTO> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(toDTO(user));
        }
        return dtos;
    }
}
