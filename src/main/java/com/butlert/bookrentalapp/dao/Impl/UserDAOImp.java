package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.UserDAO;
import com.butlert.bookrentalapp.db.entity.User;
import com.butlert.bookrentalapp.db.mapper.UserMapper;
import com.butlert.bookrentalapp.db.repository.UserRepository;
import com.butlert.bookrentalapp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDAOImp implements UserDAO {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO findUserById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDTO).orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    @Override
    public UserDTO saveUser(User user) {
        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    @Override
    public UserDTO findUserByEmail(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress).map(UserMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + emailAddress));
    }

    @Override
    public UserDTO findUserByLastName(String lastName) {
        return userRepository.findByLastName(lastName).map(UserMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found with last name: " + lastName));
    }
}
