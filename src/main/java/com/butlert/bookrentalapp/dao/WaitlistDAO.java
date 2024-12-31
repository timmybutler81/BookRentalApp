package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.Waitlist;
import com.butlert.bookrentalapp.db.entity.user.User;
import com.butlert.bookrentalapp.dto.WaitlistDTO;
import com.butlert.bookrentalapp.dto.user.UserDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WaitlistDAO {
    Waitlist saveToWaitlist(Waitlist waitlist);

    boolean existsWaitlistByUserIdAndBookId(Long bookId, Long userId);

    List<WaitlistDTO> findWaitlistByBookIdOrderedByAddDate(Long bookId);

    List<WaitlistDTO> findWaitlistByBookId(Long bookId);
}