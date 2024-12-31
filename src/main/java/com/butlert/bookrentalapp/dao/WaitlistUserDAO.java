package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.dto.WaitlistUserDTO;
import com.butlert.bookrentalapp.dto.user.UserDTO;

import java.util.List;

public interface WaitlistUserDAO {
    List<WaitlistUserDTO> findWaitlistsByUserId(Long userId);

    UserDTO findNextUserOnWaitlistByBookId(Long bookId);

    int calculateEstimatedWaitDays(Long bookId, Long userId);
}
