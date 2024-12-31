package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.WaitlistDAO;
import com.butlert.bookrentalapp.dao.WaitlistUserDAO;
import com.butlert.bookrentalapp.dao.book.BookLicenseDAO;
import com.butlert.bookrentalapp.dao.rental.BookRentalTransactionDAO;
import com.butlert.bookrentalapp.dao.user.UserDAO;
import com.butlert.bookrentalapp.dao.user.UserTypeDAO;
import com.butlert.bookrentalapp.db.entity.user.User;
import com.butlert.bookrentalapp.db.mapper.WaitlistMapper;
import com.butlert.bookrentalapp.db.mapper.user.UserMapper;
import com.butlert.bookrentalapp.db.repository.WaitlistRepository;
import com.butlert.bookrentalapp.db.repository.user.UserRepository;
import com.butlert.bookrentalapp.dto.WaitlistDTO;
import com.butlert.bookrentalapp.dto.WaitlistUserDTO;
import com.butlert.bookrentalapp.dto.book.BookLicenseDTO;
import com.butlert.bookrentalapp.dto.rental.BookRentalTransactionDTO;
import com.butlert.bookrentalapp.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class WaitlistUserDAOImp implements WaitlistUserDAO {

    @Autowired
    private WaitlistRepository waitlistRepository;

    @Autowired
    private WaitlistDAO waitlistDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserTypeDAO userTypeDAO;

    @Autowired
    private BookLicenseDAO bookLicenseDAO;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRentalTransactionDAO bookRentalTransactionDAO;

    @Override
    public List<WaitlistUserDTO> findWaitlistsByUserId(Long userId) {
        //find all of them and collect them
        List<WaitlistDTO> waitlist = waitlistRepository.findWaitlistsByUserId(userId)
                .stream()
                .map(WaitlistMapper::toDTO)
                .collect(Collectors.toList());
        //find user
        UserDTO userDTO = userDAO.findUserById(userId);

        return waitlist.stream()
                .map(waitlistDTO -> new WaitlistUserDTO(
                        waitlistDTO.getId(),          // Set waitlist ID
                        userId,                      // Set user ID
                        waitlistDTO,                 // Populate WaitlistDTO
                        userDTO                      // Populate UserDTO
                ))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findNextUserOnWaitlistByBookId (Long bookId) {
        User user = userRepository.findById(waitlistRepository.nextUserOnWaitlistByBookId(bookId))
                .orElseThrow(() -> new RuntimeException("User not found on waitlist"));
        return UserMapper.toDTO(user);
        //here I need to have a query power this to find the next user on the waitlist based on bookId and date added to waitlist
    }

    public int calculateEstimatedWaitDays(Long bookId, Long userId) {
        // Step 1: Retrieve all licenses for the book
        List<BookLicenseDTO> licenses = bookLicenseDAO.findLicensesByBookId(bookId);

        // Step 2: Retrieve all transactions for the book licenses
        List<BookRentalTransactionDTO> transactions = bookRentalTransactionDAO.findTransactionsByBookId(bookId);

        // Step 3: Retrieve the waitlist for the book, ordered by add date
        List<WaitlistDTO> waitlist = waitlistDAO.findWaitlistByBookIdOrderedByAddDate(bookId);

        // Step 4: Simulate the return and assignment process
        // Create a map to track licenses and their availability
        Map<Long, LocalDate> licenseAvailabilityMap = new HashMap<>();
        for (BookLicenseDTO license : licenses) {
            licenseAvailabilityMap.put(license.getId(), LocalDate.now());
        }

        // Populate the map with due dates from transactions
        for (BookRentalTransactionDTO transaction : transactions) {
            licenseAvailabilityMap.put(transaction.getBookLicenseId(), transaction.getDueDate());
        }

        // Step 5: Assign books as they are returned
        LocalDate userWaitEndDate = null;

        for (WaitlistDTO waitlistEntry : waitlist) {
            Long waitlistUserId = waitlistEntry.getUserId();

            // Find the earliest available license
            Long availableLicenseId = licenseAvailabilityMap.entrySet()
                    .stream()
                    .min(Comparator.comparing(Map.Entry::getValue))
                    .map(Map.Entry::getKey)
                    .orElseThrow(() -> new IllegalStateException("No licenses available"));

            // Get the availability date for this license
            LocalDate availabilityDate = licenseAvailabilityMap.get(availableLicenseId);

            // Update the availability for the next user
            UserDTO user = userDAO.findUserById(waitlistUserId);
            int checkoutDuration = userTypeDAO.findCheckoutDurationByUserType(user.getUserTypeId());
            licenseAvailabilityMap.put(availableLicenseId, availabilityDate.plusDays(checkoutDuration));

            // If this is the target user, record the wait end date
            if (waitlistUserId.equals(userId)) {
                userWaitEndDate = availabilityDate;
                break;
            }
        }

        // Step 6: Calculate the remaining wait time
        if (userWaitEndDate == null) {
            throw new IllegalArgumentException("User is not on the waitlist for this book");
        }

        return (int) ChronoUnit.DAYS.between(LocalDate.now(), userWaitEndDate);
    }
}
