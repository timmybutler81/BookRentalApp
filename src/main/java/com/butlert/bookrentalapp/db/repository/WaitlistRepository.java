package com.butlert.bookrentalapp.db.repository;

import com.butlert.bookrentalapp.db.entity.Waitlist;
import com.butlert.bookrentalapp.dto.WaitlistDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaitlistRepository extends JpaRepository<Waitlist, Long> {

    @Query(value = "SELECT EXISTS(SELECT 1 FROM waitlist WHERE processed_flag = 'N' AND user_id = :userId AND book_id = :bookId)", nativeQuery = true)
    boolean existsWaitlistByUserIdAndBookId(@Param("userId") Long userId,@Param("bookId") Long bookId);

    List<Waitlist> findWaitlistsByUserId(Long userId);

    List<Waitlist> findWaitlistByBookId(Long bookId);

    @Query(value = "SELECT user_id FROM waitlist WHERE book_id = :bookId AND waitlist_status = 'Pending' AND processed_flag = 'N' ORDER BY waitlist_add_date ASC", nativeQuery = true)
    Long nextUserOnWaitlistByBookId(@Param("bookId") Long bookId);

    @Query(value = "SELECT * FROM waitlist WHERE book_id = :bookId AND waitlist_status = 'Pending' AND processed_flag = 'N' ORDER BY waitlist_add_date ASC;", nativeQuery = true)
    List<Waitlist> findWaitlistByBookIdOrderedByAddDate(@Param("bookId") Long bookId);
}
