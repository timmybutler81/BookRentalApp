package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.UserTypeDAO;
import com.butlert.bookrentalapp.db.entity.UserType;
import com.butlert.bookrentalapp.db.mapper.UserTypeMapper;
import com.butlert.bookrentalapp.dto.UserTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService {

    @Autowired
    private UserTypeDAO userTypeDAO;

    public List<UserTypeDTO> getAllUserTypes() {
        return userTypeDAO.findAllUserTypes();
    }

    public UserTypeDTO getUserTypeById(Long id) {
        return userTypeDAO.findUserTypeById(id);
    }

    public UserTypeDTO saveUserType(UserTypeDTO userTypeDTO) {
        UserType userType = UserTypeMapper.toEntity(userTypeDTO);
        return userTypeDAO.saveUserType(userType);
    }
}
