package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.UserDAO;
import com.butlert.bookrentalapp.db.entity.User;
import com.butlert.bookrentalapp.db.mapper.UserMapper;
import com.butlert.bookrentalapp.dto.UserDTO;
import com.butlert.bookrentalapp.validator.ValidatorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private ValidatorImp validatorImp;

    @Autowired
    private UserDAO userDAO;

    public List<UserDTO> getAllUsers() {
        return userDAO.findAllUsers();
    }

    public UserDTO getUserById(Long id) {
        return userDAO.findUserById(id);
    }

    public UserDTO saveUser(UserDTO userDTO) {
        validatorImp.validate(userDTO);
        User user = UserMapper.toEntity(userDTO);
        return userDAO.saveUser(user);
    }

    public UserDTO getUserByEmail(String emailAddress) {
        return userDAO.findUserByEmail(emailAddress);
    }

    public UserDTO getUserByLastName(String lastName) {
        return userDAO.findUserByLastName(lastName);
    }
}
