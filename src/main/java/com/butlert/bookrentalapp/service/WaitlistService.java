package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.WaitlistDAO;
import com.butlert.bookrentalapp.dao.WaitlistUserDAO;
import com.butlert.bookrentalapp.dao.book.BookLicenseDAO;
import com.butlert.bookrentalapp.dao.user.UserDAO;
import com.butlert.bookrentalapp.db.entity.Waitlist;
import com.butlert.bookrentalapp.db.mapper.WaitlistMapper;
import com.butlert.bookrentalapp.dto.WaitlistDTO;
import com.butlert.bookrentalapp.dto.WaitlistUserDTO;
import com.butlert.bookrentalapp.dto.book.BookDTO;
import com.butlert.bookrentalapp.dto.book.BookDetailsWithWaitTimeDTO;
import com.butlert.bookrentalapp.dto.user.UserDTO;
import com.butlert.bookrentalapp.enums.WaitlistStatus;
import com.butlert.bookrentalapp.service.book.BookService;
import com.butlert.bookrentalapp.validator.ValidatorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WaitlistService {

    private final BookService bookService;
    private final UserDAO userDAO;
    private final BookLicenseDAO bookLicenseDAO;
    private final WaitlistDAO waitlistDAO;
    private final WaitlistUserDAO waitlistUserDAO;
    private final ValidatorImp validator;

    @Autowired
    public WaitlistService(
            BookService bookService,
            UserDAO userDAO,
            BookLicenseDAO bookLicenseDAO,
            WaitlistDAO waitlistDAO,
            WaitlistUserDAO waitlistUserDAO,
            ValidatorImp validator) {
        this.bookService = bookService;
        this.userDAO = userDAO;
        this.bookLicenseDAO = bookLicenseDAO;
        this.waitlistDAO = waitlistDAO;
        this.waitlistUserDAO = waitlistUserDAO;
        this.validator = validator;
    }

    public WaitlistDTO addUserToWaitlist(Long bookId, Long userId) {
        BookDTO bookDTO = bookService.getBookById(bookId);
        validator.validate(bookDTO);
        UserDTO userDTO = userDAO.findUserById(userId);
        validator.validate(userDTO);
        if (bookLicenseDAO.findAvailabilityByBookId(bookId)) {
            throw new IllegalArgumentException("Book has availability, not adding to waitlist");
        }
        Waitlist waitlist = new Waitlist();
        waitlist.setUserId(userId);
        waitlist.setBookId(bookId);
        waitlist.setWaitlistStatus("Pending");
        waitlist.setWaitlistAddDate(LocalDate.now());
        waitlist.setProcessedFlag(false);
        return WaitlistMapper.toDTO(waitlistDAO.saveToWaitlist(waitlist));
    }

    public void removeUserFromWaitlist(Long bookId, Long userId) {
        BookDTO bookDTO = bookService.getBookById(bookId);
        validator.validate(bookDTO);
        UserDTO userDTO = userDAO.findUserById(userId);
        validator.validate(userDTO);
        if (!waitlistDAO.existsWaitlistByUserIdAndBookId(bookId, userId)) {
            throw new IllegalArgumentException("User is not on waitlist");
        }
        waitlistDAO.updateWaitlist(bookId, userId, String.valueOf(WaitlistStatus.COMPLETE), "Y");
    }

    public List<WaitlistUserDTO> getWaitlistByUser(Long userId) {
        UserDTO userDTO = userDAO.findUserById(userId);
        validator.validate(userDTO);
        return waitlistUserDAO.findWaitlistsByUserId(userId);
    }

    public UserDTO getNextUserOnWaitlistByBookId(Long bookId) {
        return waitlistUserDAO.findNextUserOnWaitlistByBookId(bookId);
    }

    public List<WaitlistDTO> getWaitlistByBookId(Long bookId) {
        return waitlistDAO.findWaitlistByBookId(bookId);
    }

    public BookDetailsWithWaitTimeDTO getBookDetailsWithWaitTime(Long bookId, Long userId) {
        BookDTO book = bookService.getBookById(bookId);
        int estimatedWaitDays = waitlistUserDAO.calculateEstimatedWaitDays(bookId, userId);
        return new BookDetailsWithWaitTimeDTO(book, estimatedWaitDays);
    }
}
