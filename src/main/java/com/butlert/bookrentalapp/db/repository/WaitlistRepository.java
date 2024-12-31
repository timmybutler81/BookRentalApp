package com.butlert.bookrentalapp.db.repository;

import com.butlert.bookrentalapp.db.entity.Waitlist;
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
}
