package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.user.UserDAO;
import com.butlert.bookrentalapp.db.entity.user.User;
import com.butlert.bookrentalapp.db.mapper.user.UserMapper;
import com.butlert.bookrentalapp.db.repository.user.UserRepository;
import com.butlert.bookrentalapp.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDAOImp implements UserDAO {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    @Override
    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findUserByEmail(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress)
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findUserByLastName(String lastName) {
        return userRepository.findByLastName(lastName)
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
