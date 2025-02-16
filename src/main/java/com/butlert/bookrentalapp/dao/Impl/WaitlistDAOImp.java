package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.WaitlistDAO;
import com.butlert.bookrentalapp.db.entity.Waitlist;
import com.butlert.bookrentalapp.db.mapper.WaitlistMapper;
import com.butlert.bookrentalapp.db.repository.WaitlistRepository;
import com.butlert.bookrentalapp.dto.WaitlistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


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
        boolean temp = false;
        if (waitlistRepository.existsWaitlistByUserIdAndBookId(userId, bookId) > 0) {
            temp = true;
        }
        return temp;
    }

    @Override
    public List<WaitlistDTO> findWaitlistByBookIdOrderedByAddDate(Long bookId) {
        return waitlistRepository.findWaitlistByBookIdOrderedByAddDate(bookId)
                .stream()
                .map(WaitlistMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<WaitlistDTO> findWaitlistByBookId(Long bookId) {
        return waitlistRepository.findWaitlistByBookId(bookId)
                .stream()
                .map(WaitlistMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Waitlist findWaitlistByBookIdAndUserId(Long bookId, Long userId) {
        return waitlistRepository.findWaitlistByBookIdAndUserId(bookId, userId);
    }

    @Override
    public void updateWaitlist(Long bookId, Long userId, String waitlistStatus, String processedFlag) {
        waitlistRepository.updateWaitlist(bookId, userId, waitlistStatus, processedFlag);
    }
}
