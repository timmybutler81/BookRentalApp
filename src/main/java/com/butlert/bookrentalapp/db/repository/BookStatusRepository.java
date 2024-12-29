package com.butlert.bookrentalapp.db.repository;

import com.butlert.bookrentalapp.db.entity.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStatusRepository extends JpaRepository<BookStatus, Long> {
}
