package com.qirblek.userservice.service;

import com.qirblek.userservice.dto.UserLoginDTO;
import com.qirblek.userservice.dto.UserRegisterDTO;
import com.qirblek.userservice.entity.User;
import com.qirblek.userservice.exception.InvalidCredentialsException;
import com.qirblek.userservice.mapper.UserMapper;
import com.qirblek.userservice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public AuthService(UserRepository userRepository,  UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));

        return BCrypt.checkpw(password, user.getPassword());

    }

    public void register(UserRegisterDTO userRegisterDTO) {
        User user = userMapper.toEntity(userRegisterDTO);
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

}
