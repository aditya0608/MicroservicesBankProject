package com.aditya.user.service;

import com.aditya.user.model.dto.UserDTO;
import com.aditya.user.model.entity.User;
import com.aditya.user.repository.UserRepository;
import com.aditya.user.service.assembler.UserAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService  {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private UserAssembler userAssembler;

    public UserDTO createUser(UserDTO userDTO) {
        User user = userAssembler.toDomainObject(userDTO);
        userRepository.save(user);
        return userAssembler.fromDomainObject(user);
    }

    public UserDTO getUserById(String userId) {
        return userRepository.findById(userId)
                .map(UserAssembler::fromDomainObject)
                .orElse(null);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserAssembler::fromDomainObject)
                .collect(Collectors.toList());
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}

