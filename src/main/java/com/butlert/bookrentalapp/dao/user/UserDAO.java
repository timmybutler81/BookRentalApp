package com.butlert.bookrentalapp.dao.user;

import com.butlert.bookrentalapp.dto.user.UserDTO;

import java.util.List;

public interface UserDAO {
    UserDTO saveUser(UserDTO userDTO);

    UserDTO findUserById(Long id);

    List<UserDTO> findAllUsers();

    List<UserDTO> findUserByEmail(String emailAddress);

    List<UserDTO> findUserByLastName(String lastName);
}
