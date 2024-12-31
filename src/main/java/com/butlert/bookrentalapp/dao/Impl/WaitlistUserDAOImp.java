package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.WaitlistDAO;
import com.butlert.bookrentalapp.dao.WaitlistUserDAO;
import com.butlert.bookrentalapp.dao.user.UserDAO;
import com.butlert.bookrentalapp.db.mapper.WaitlistMapper;
import com.butlert.bookrentalapp.db.repository.WaitlistRepository;
import com.butlert.bookrentalapp.dto.WaitlistDTO;
import com.butlert.bookrentalapp.dto.WaitlistUserDTO;
import com.butlert.bookrentalapp.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class WaitlistUserDAOImp implements WaitlistUserDAO {

    @Autowired
    private WaitlistUserDAO waitlistUserDAO;

    @Autowired
    private WaitlistRepository waitlistRepository;

    @Autowired
    private WaitlistDAO waitlistDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<WaitlistUserDTO> findWaitlistsByUserId(Long userId) {
        //find all of them and collect them
        List<WaitlistDTO> waitlist = waitlistRepository.findWaitlistsByUserId(userId)
                .stream()
                .map(WaitlistMapper::toDTO)
                .collect(Collectors.toList());
        //find user
        UserDTO userDTO = userDAO.findUserById(userId);

        return waitlist.stream()
                .map(waitlistDTO -> new WaitlistUserDTO(
                        waitlistDTO.getId(),          // Set waitlist ID
                        userId,                      // Set user ID
                        waitlistDTO,                 // Populate WaitlistDTO
                        userDTO                      // Populate UserDTO
                ))
                .collect(Collectors.toList());
    }
}
