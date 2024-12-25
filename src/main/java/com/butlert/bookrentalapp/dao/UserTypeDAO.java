package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.UserType;
import com.butlert.bookrentalapp.dto.UserTypeDTO;

import java.util.List;

public interface UserTypeDAO {

    List<UserTypeDTO> findAllUserTypes();

    UserTypeDTO findUserTypeById(Long id);

    UserTypeDTO saveUserType(UserType userType);
}