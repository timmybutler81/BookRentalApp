package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.book.BookStatusDAO;
import com.butlert.bookrentalapp.db.entity.book.BookStatus;
import com.butlert.bookrentalapp.db.mapper.book.BookStatusMapper;
import com.butlert.bookrentalapp.db.repository.book.BookStatusRepository;
import com.butlert.bookrentalapp.dto.book.BookStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookStatusDAOImp implements BookStatusDAO {

    @Autowired
    private BookStatusRepository bookStatusRepository;

    @Override
    public BookStatusDTO saveBookStatus(BookStatusDTO bookStatusDTO) {
        BookStatus BookStatus = BookStatusMapper.toEntity(bookStatusDTO);
        BookStatus savedBookStatus = bookStatusRepository.save(BookStatus);
        return BookStatusMapper.toDTO(savedBookStatus);
    }

    @Override
    public BookStatusDTO findBookStatusById(Long id) {
        BookStatus bookStatus = bookStatusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book Status not found"));
        return BookStatusMapper.toDTO(bookStatus);
    }

    @Override
    public List<BookStatusDTO> findAllBookStatuses() {
        return bookStatusRepository.findAll()
                .stream()
                .map(BookStatusMapper::toDTO)
                .collect(Collectors.toList());
    }
}
