package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.BookDAO;
import com.butlert.bookrentalapp.dao.BookLicenseDAO;
import com.butlert.bookrentalapp.dao.UserDAO;
import com.butlert.bookrentalapp.dao.WaitlistDAO;
import com.butlert.bookrentalapp.db.entity.Book;
import com.butlert.bookrentalapp.db.entity.User;
import com.butlert.bookrentalapp.db.entity.Waitlist;
import com.butlert.bookrentalapp.db.mapper.WaitlistMapper;
import com.butlert.bookrentalapp.db.repository.BookLicenseRepository;
import com.butlert.bookrentalapp.db.repository.BookRepository;
import com.butlert.bookrentalapp.db.repository.UserRepository;
import com.butlert.bookrentalapp.db.repository.WaitlistRepository;
import com.butlert.bookrentalapp.dto.BookDTO;
import com.butlert.bookrentalapp.dto.UserDTO;
import com.butlert.bookrentalapp.dto.WaitlistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WaitlistService {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BookLicenseDAO bookLicenseDAO;

    @Autowired
    private WaitlistDAO waitlistDAO;

    public WaitlistDTO addUserToWaitlist(Long bookId, Long userId) {
        BookDTO bookDTO = bookDAO.findBookById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        UserDTO userDTO = userDAO.findUserById(userId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (!bookLicenseDAO.findAvailabilityByBookId(bookId)) {
            throw new IllegalArgumentException("Book has availability");
        }

        Waitlist waitlist = new Waitlist();
        waitlist.setUserId(userId);
        waitlist.setBookId(bookId);
        waitlist.setWaitlistStatus("Pending");
        waitlist.setWaitlistAddDate(LocalDate.now());

        return WaitlistMapper.toDTO(waitlistDAO.saveToWaitlist(waitlist));
    }

    public WaitlistDTO removeUserFromWaitlist(Long bookId, Long userId) {
        BookDTO bookDTO = bookDAO.findBookById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        UserDTO userDTO = userDAO.findUserById(userId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (!waitlistDAO.existsWaitlistByUserIdAndBookId(bookId, userId)) {
            throw new IllegalArgumentException("User is not on waitlist");
        }

        Waitlist waitlist = new Waitlist();
        waitlist.setUserId(userId);
        waitlist.setBookId(bookId);
        waitlist.setWaitlistStatus("Complete");
        waitlist.setProcessedFlag(true);

        return WaitlistMapper.toDTO(waitlistDAO.saveToWaitlist(waitlist));
    }

    public void getWaitlistByUser() {

    }

    public void getWaitlistByBookId() {

    }

}
