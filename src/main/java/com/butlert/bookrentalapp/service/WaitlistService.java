package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.WaitlistUserDAO;
import com.butlert.bookrentalapp.dao.book.BookDAO;
import com.butlert.bookrentalapp.dao.book.BookLicenseDAO;
import com.butlert.bookrentalapp.dao.user.UserDAO;
import com.butlert.bookrentalapp.dao.WaitlistDAO;
import com.butlert.bookrentalapp.db.entity.Waitlist;
import com.butlert.bookrentalapp.db.mapper.WaitlistMapper;
import com.butlert.bookrentalapp.db.repository.WaitlistRepository;
import com.butlert.bookrentalapp.dto.WaitlistUserDTO;
import com.butlert.bookrentalapp.dto.book.BookDTO;
import com.butlert.bookrentalapp.dto.book.BookLicenseDTO;
import com.butlert.bookrentalapp.dto.rental.BookRentalTransactionDTO;
import com.butlert.bookrentalapp.dto.user.UserDTO;
import com.butlert.bookrentalapp.dto.WaitlistDTO;
import com.butlert.bookrentalapp.service.rental.BookRentalTransactionService;
import com.butlert.bookrentalapp.validator.ValidatorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private BookRentalTransactionService bookRentalTransactionService;

    @Autowired
    private WaitlistUserDAO waitlistUserDAO;

    @Autowired
    private ValidatorImp validator;

    public WaitlistDTO addUserToWaitlist(Long bookId, Long userId) {
        BookDTO bookDTO = bookDAO.findBookById(bookId);
        validator.validate(bookDTO);
        UserDTO userDTO = userDAO.findUserById(userId);
        validator.validate(userDTO);
        //check is book is not available
        if (!bookLicenseDAO.findAvailabilityByBookId(bookId)) {
            throw new IllegalArgumentException("Book has availability, not adding to waitlist");
        }
        //check user is not on waitlist

        Waitlist waitlist = new Waitlist();
        waitlist.setUserId(userId);
        waitlist.setBookId(bookId);
        waitlist.setWaitlistStatus("Pending");
        waitlist.setWaitlistAddDate(LocalDate.now());
        return WaitlistMapper.toDTO(waitlistDAO.saveToWaitlist(waitlist));
    }

    public void removeUserFromWaitlist(Long bookId, Long userId) {
        BookDTO bookDTO = bookDAO.findBookById(bookId);
        validator.validate(bookDTO);
        UserDTO userDTO = userDAO.findUserById(userId);
        validator.validate(userDTO);
        //check user is on waitlist
        if (!waitlistDAO.existsWaitlistByUserIdAndBookId(bookId, userId)) {
            throw new IllegalArgumentException("User is not on waitlist");
        }

        Waitlist waitlist = new Waitlist();
        waitlist.setUserId(userId);
        waitlist.setBookId(bookId);
        waitlist.setWaitlistStatus("Complete");
        waitlist.setProcessedFlag(true);
    }

    public BookRentalTransactionDTO checkOutBookFromWaitList(Long bookId, Long userId) {
        Optional<BookLicenseDTO> bookLicenseDTO = bookLicenseDAO.findAvailableLicenseByBookId(bookId);
        BookDTO bookDTO = bookDAO.findBookById(bookId);
        validator.validate(bookDTO);
        UserDTO userDTO = userDAO.findUserById(userId);
        validator.validate(userDTO);

        if (bookLicenseDTO.isPresent()) {
            BookRentalTransactionDTO bookRentalTransactionDTO = bookRentalTransactionService.checkoutBook(bookLicenseDTO.get().getId(), userId);
            removeUserFromWaitlist(bookId, userId);
            return bookRentalTransactionDTO;
        } else {
            throw new IllegalArgumentException("No available Licenses to check out");
        }
    }

    public List<WaitlistUserDTO> getWaitlistByUser(Long userId) {
        UserDTO userDTO = userDAO.findUserById(userId);
        validator.validate(userDTO);
        return waitlistUserDAO.findWaitlistsByUserId(userId);
    }

    public void getWaitlistByBookId(Long bookId) {

    }

}
