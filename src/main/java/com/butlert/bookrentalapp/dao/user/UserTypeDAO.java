package com.butlert.bookrentalapp.dao.user;

import com.butlert.bookrentalapp.dto.user.UserTypeDTO;

import java.util.List;

public interface UserTypeDAO {
    UserTypeDTO saveUserType(UserTypeDTO userTypeDTO);

    UserTypeDTO findUserTypeById(Long id);

    List<UserTypeDTO> findAllUserTypes();

    int findCheckoutDurationByUserType(Long id);
}