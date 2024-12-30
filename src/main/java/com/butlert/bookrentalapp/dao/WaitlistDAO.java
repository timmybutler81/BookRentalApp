package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.Waitlist;
import com.butlert.bookrentalapp.dto.WaitlistDTO;

public interface WaitlistDAO {
    Waitlist saveToWaitlist(Waitlist waitlist);

    boolean existsWaitlistByUserIdAndBookId(Long bookId, Long userId);
}
