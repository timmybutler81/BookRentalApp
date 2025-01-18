package com.butlert.bookrentalapp.service.rental;

import com.butlert.bookrentalapp.dao.book.BookLicenseDAO;
import com.butlert.bookrentalapp.dao.rental.BookRentalTransactionDAO;
import com.butlert.bookrentalapp.dao.user.UserDAO;
import com.butlert.bookrentalapp.dao.user.UserTypeDAO;
import com.butlert.bookrentalapp.db.mapper.book.BookMapper;
import com.butlert.bookrentalapp.db.repository.book.BookRepository;
import com.butlert.bookrentalapp.dto.book.BookDTO;
import com.butlert.bookrentalapp.dto.book.BookLicenseDTO;
import com.butlert.bookrentalapp.dto.rental.BookRentalTransactionDTO;
import com.butlert.bookrentalapp.dto.user.UserDTO;
import com.butlert.bookrentalapp.service.WaitlistService;
import com.butlert.bookrentalapp.validator.ValidatorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookRentalService {

    @Autowired
    private ValidatorImp validator;

    @Autowired
    private BookLicenseDAO bookLicenseDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserTypeDAO userTypeDAO;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private WaitlistService waitlistService;

    @Autowired
    private BookRentalTransactionDAO bookRentalTransactionDAO;

    public BookRentalTransactionDTO checkoutBook(Long licenseId, Long userId) {
        //validate book license
        BookLicenseDTO bookLicenseDTO = bookLicenseDAO.findLicenseById(licenseId);
        validator.validate(bookLicenseDTO);
        if (!bookLicenseDTO.isAvailable()) {
            throw new RuntimeException("Book License is not available for checkout");
        }
        //validate user
        UserDTO userDTO = userDAO.findUserById(userId);
        validator.validate(userDTO);
        bookLicenseDAO.updateLicenseAvailability(licenseId, false);
        //check out book
        BookRentalTransactionDTO bookRentalTransactionDTO = new BookRentalTransactionDTO();
        bookRentalTransactionDTO.setBookLicenseId(bookLicenseDTO.getId());
        bookRentalTransactionDTO.setUserId(userDTO.getId());
        bookRentalTransactionDTO.setTransactionStatusId(1L);
        bookRentalTransactionDTO.setCheckOutDate(LocalDate.now());
        bookRentalTransactionDTO.setDueDate(LocalDate.now().plusDays(userTypeDAO.findCheckoutDurationByUserType(userDTO.getUserTypeId())));

        return bookRentalTransactionDAO.saveTransaction(bookRentalTransactionDTO);
    }

    public BookRentalTransactionDTO returnBook(Long licenseId, Long userId) {
        //make sure user has a checked out book
        System.out.println("Starting return book licenseId: " + licenseId + "userId: " + userId);
        BookRentalTransactionDTO existingTransaction = bookRentalTransactionDAO.findTransactionByLicenseAndUser(licenseId, userId);
        if (existingTransaction == null) {
            throw new IllegalArgumentException("No existing transaction found");
        }
        //validate
        System.out.println("Passed 1");
        BookLicenseDTO bookLicenseDTO = bookLicenseDAO.findLicenseById(licenseId);
        validator.validate(bookLicenseDTO);
        System.out.println("Passed 2");
        UserDTO userDTO = userDAO.findUserById(userId);
        validator.validate(userDTO);
        //update
        System.out.println("Passed 3");
        bookLicenseDAO.updateLicenseAvailability(licenseId, true);
        existingTransaction.setTransactionStatusId(1L);
        existingTransaction.setDateReturned(LocalDate.now());
        //check out next book
        System.out.println("Passed 4");
        System.out.println("Finishing return book " + existingTransaction);
        return bookRentalTransactionDAO.saveTransaction(existingTransaction);
    }

    public void checkOutBookFromWaitList(Long bookId) {
        Optional<BookLicenseDTO> bookLicenseDTO = bookLicenseDAO.findAvailableLicenseByBookId(bookId);
        BookDTO bookDTO = bookRepository.findById(bookId)
                .map(BookMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        UserDTO userDTO = waitlistService.getNextUserOnWaitlistByBookId(bookId);
        validator.validate(userDTO);

        if (bookLicenseDTO.isPresent()) {
            BookRentalTransactionDTO bookRentalTransactionDTO = checkoutBook(bookLicenseDTO.get().getId(), userDTO.getId());
            waitlistService.removeUserFromWaitlist(bookDTO.getId(), userDTO.getId());
        } else {
            throw new IllegalArgumentException("No available Licenses to check out");
        }
    }
}
