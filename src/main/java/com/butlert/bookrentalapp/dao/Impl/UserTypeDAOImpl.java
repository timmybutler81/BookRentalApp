package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.UserTypeDAO;
import com.butlert.bookrentalapp.db.entity.UserType;
import com.butlert.bookrentalapp.db.mapper.UserTypeMapper;
import com.butlert.bookrentalapp.db.repository.UserTypeRepository;
import com.butlert.bookrentalapp.dto.UserTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserTypeDAOImpl implements UserTypeDAO {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public List<UserTypeDTO> findAllUserTypes() {
        return userTypeRepository.findAll()
                .stream()
                .map(UserTypeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserTypeDTO findUserTypeById(Long id) {
        return userTypeRepository.findById(id)
                .map(UserTypeMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("User Type Not Found"));
    }

    @Override
    public UserTypeDTO saveUserType(UserType userType) {
        UserType savedUserType = userTypeRepository.save(userType);
        return UserTypeMapper.toDTO(savedUserType);
    }
}
