package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.user.UserTypeDAO;
import com.butlert.bookrentalapp.db.entity.user.UserType;
import com.butlert.bookrentalapp.db.mapper.user.UserTypeMapper;
import com.butlert.bookrentalapp.db.repository.user.UserTypeRepository;
import com.butlert.bookrentalapp.dto.user.UserTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserTypeDAOImpl implements UserTypeDAO {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public UserTypeDTO saveUserType(UserTypeDTO userTypeDTO) {
        UserType userType = UserTypeMapper.toEntity(userTypeDTO);
        UserType savedUserType = userTypeRepository.save(userType);
        return UserTypeMapper.toDTO(savedUserType);
    }

    @Override
    public UserTypeDTO findUserTypeById(Long id) {
        UserType userType = userTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Type not found"));
        return UserTypeMapper.toDTO(userType);
    }

    @Override
    public List<UserTypeDTO> findAllUserTypes() {
        return userTypeRepository.findAll()
                .stream()
                .map(UserTypeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public int findCheckoutDurationByUserType(Long id) {
        return userTypeRepository.findCheckoutDurationByUserTypeId(id);
    }


}
