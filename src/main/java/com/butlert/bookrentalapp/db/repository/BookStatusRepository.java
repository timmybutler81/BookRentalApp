package com.butlert.bookrentalapp.db.repository;

import com.butlert.bookrentalapp.db.entity.Book;
import com.butlert.bookrentalapp.db.entity.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface BookStatusRepository extends JpaRepository<BookStatus, Long> {
}
