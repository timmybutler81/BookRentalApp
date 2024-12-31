package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.WaitlistDAO;
import com.butlert.bookrentalapp.db.entity.Waitlist;
import com.butlert.bookrentalapp.db.repository.WaitlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class WaitlistDAOImp implements WaitlistDAO {

    @Autowired
    private WaitlistRepository waitlistRepository;

    @Override
    public Waitlist saveToWaitlist(Waitlist waitlist) {
        return waitlistRepository.save(waitlist);
    }

    @Override
    public boolean existsWaitlistByUserIdAndBookId(Long userId, Long bookId) {
        return waitlistRepository.existsWaitlistByUserIdAndBookId(userId, bookId);
    }
}
