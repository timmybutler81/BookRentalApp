package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.Waitlist;
import com.butlert.bookrentalapp.dto.WaitlistDTO;
import com.butlert.bookrentalapp.dto.WaitlistUserDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WaitlistDAO {
    Waitlist saveToWaitlist(Waitlist waitlist);

    boolean existsWaitlistByUserIdAndBookId(Long bookId, Long userId);

    List<WaitlistDTO> findWaitlistByBookIdOrderedByAddDate(Long bookId);

    List<WaitlistDTO> findWaitlistByBookId(Long bookId);

    Waitlist findWaitlistByBookIdAndUserId(Long bookId, Long userId);

    void updateWaitlist(Long bookId, Long userId, String waitlistStatus, String processedFlag);
}