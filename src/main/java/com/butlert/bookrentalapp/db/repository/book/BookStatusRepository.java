package com.butlert.bookrentalapp.db.repository.book;

import com.butlert.bookrentalapp.db.entity.book.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStatusRepository extends JpaRepository<BookStatus, Long> {
}
