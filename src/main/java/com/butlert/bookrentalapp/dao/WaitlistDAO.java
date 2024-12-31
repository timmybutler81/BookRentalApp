package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.Waitlist;
import com.butlert.bookrentalapp.dto.WaitlistDTO;

import java.util.List;

public interface WaitlistDAO {
    Waitlist saveToWaitlist(Waitlist waitlist);

    boolean existsWaitlistByUserIdAndBookId(Long bookId, Long userId);

    List<WaitlistDTO> findWaitlistByBookIdOrderedByAddDate(Long bookId);

    List<WaitlistDTO> findWaitlistByBookId(Long bookId);
}