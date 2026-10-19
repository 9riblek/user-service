package com.qirblek.userservice.service;

import com.qirblek.userservice.dto.UserResponseDTO;
import com.qirblek.userservice.enums.Role;
import com.qirblek.userservice.exception.UserNotFoundException;
import com.qirblek.userservice.mapper.UserMapper;
import com.qirblek.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository,  UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

//    public UserResponseDTO save(User user) {
//        return userMapper.toDTO(userRepository.save(user));
//    }

    public UserResponseDTO findByUsername(String username) {
        return userMapper.toDTO(
                userRepository.findByUsername(username)
                    .orElseThrow(() -> new UserNotFoundException("User Not Found !"))
            );
    }

//    public boolean existsByUsername(String username) {
//        return userRepository.existsByUsername(username);
//    }

    public List<UserResponseDTO> findAll() {
        return userMapper.toDTO(userRepository.findAll());
    }

    public UserResponseDTO findById(UUID id) {
        return userMapper.toDTO(
            userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found !"))
        );
    }

    public List<UserResponseDTO> findByRole(Role role) {
        return userMapper.toDTO(userRepository.findByRole(role));
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

//    public boolean existsById(UUID id) {
//        return userRepository.existsById(id);
//    }

}
