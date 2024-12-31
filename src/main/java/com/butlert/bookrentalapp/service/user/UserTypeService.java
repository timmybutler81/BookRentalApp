package com.butlert.bookrentalapp.service.user;

import com.butlert.bookrentalapp.dao.user.UserTypeDAO;
import com.butlert.bookrentalapp.db.entity.user.UserType;
import com.butlert.bookrentalapp.db.mapper.user.UserTypeMapper;
import com.butlert.bookrentalapp.dto.user.UserTypeDTO;
import com.butlert.bookrentalapp.validator.ValidatorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService {

    @Autowired
    private ValidatorImp validatorImp;

    @Autowired
    private UserTypeDAO userTypeDAO;

    public UserTypeDTO addOrUpdateUserType(UserTypeDTO userTypeDTO) {
        validatorImp.validate(userTypeDTO);
        return userTypeDAO.saveUserType(userTypeDTO);
    }

    public UserTypeDTO getUserTypeById(Long id) {
        return userTypeDAO.findUserTypeById(id);
    }

    public List<UserTypeDTO> getAllUserTypes() {
        return userTypeDAO.findAllUserTypes();
    }
}
