package com.butlert.bookrentalapp.service.user;

import com.butlert.bookrentalapp.dao.user.UserDAO;
import com.butlert.bookrentalapp.dto.user.UserDTO;
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

    public UserDTO addOrUpdateUser(UserDTO userDTO) {
        validatorImp.validate(userDTO);
        return userDAO.saveUser(userDTO);
    }

    public UserDTO getUserById(Long id) {
        return userDAO.findUserById(id);
    }

    public List<UserDTO> getAllUsers() {
        return userDAO.findAllUsers();
    }

    public List<UserDTO> getUserByEmail(String emailAddress) {
        return userDAO.findUserByEmail(emailAddress);
    }

    public List<UserDTO> getUserByLastName(String lastName) {
        return userDAO.findUserByLastName(lastName);
    }
}
