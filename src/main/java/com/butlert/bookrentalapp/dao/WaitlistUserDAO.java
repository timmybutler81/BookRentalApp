package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.dto.WaitlistUserDTO;

import java.util.List;

public interface WaitlistUserDAO {
    List<WaitlistUserDTO> findWaitlistsByUserId(Long userId);
}
