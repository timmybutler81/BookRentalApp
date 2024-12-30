package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.User;
import com.butlert.bookrentalapp.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<UserDTO> findAllUsers();

    UserDTO findUserById(Long id);

    UserDTO saveUser(User user);

    UserDTO findUserByEmail(String emailAddress);

    UserDTO findUserByLastName(String lastName);
}
