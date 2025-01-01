package com.butlert.bookrentalapp.db.repository;

import com.butlert.bookrentalapp.db.entity.Waitlist;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaitlistRepository extends JpaRepository<Waitlist, Long> {

    @Query(value = "SELECT COUNT(*) > 0 FROM waitlist WHERE processed_flag = 'N' AND user_id = :userId AND book_id = :bookId", nativeQuery = true)
    int existsWaitlistByUserIdAndBookId(@Param("userId") Long userId, @Param("bookId") Long bookId);

    List<Waitlist> findWaitlistsByUserId(Long userId);

    @Query(value = "SELECT * FROM waitlist WHERE processed_flag = 'N' AND book_id = :bookId", nativeQuery = true)
    List<Waitlist> findWaitlistByBookId(@Param("bookId") Long bookId);

    @Query(value = "SELECT user_id FROM waitlist WHERE book_id = :bookId AND waitlist_status = 'Pending' AND processed_flag = 'N' ORDER BY waitlist_add_date ASC", nativeQuery = true)
    Long nextUserOnWaitlistByBookId(@Param("bookId") Long bookId);

    @Query(value = "SELECT * FROM waitlist WHERE book_id = :bookId AND waitlist_status = 'Pending' AND processed_flag = 'N' ORDER BY waitlist_add_date ASC;", nativeQuery = true)
    List<Waitlist> findWaitlistByBookIdOrderedByAddDate(@Param("bookId") Long bookId);

    @Query(value = "SELECT * FROM waitlist WHERE book_id = :bookId AND user_id = :userId AND waitlist_status = 'Pending' AND processed_flag = 'N'", nativeQuery = true)
    Waitlist findWaitlistByBookIdAndUserId(@Param("bookId") Long bookId, @Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE waitlist SET waitlist_status = :waitlistStatus, processed_flag = :processedFlag WHERE book_id = :bookId AND user_id = :userId", nativeQuery = true)
    void updateWaitlist(@Param("bookId") Long bookId, @Param("userId") Long userId, @Param("waitlistStatus") String waitlistStatus, @Param("processedFlag") String processedFlag);
}
