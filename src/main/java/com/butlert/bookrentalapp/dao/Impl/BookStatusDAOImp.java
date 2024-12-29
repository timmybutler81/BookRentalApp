package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.BookStatusDAO;
import com.butlert.bookrentalapp.db.entity.BookStatus;
import com.butlert.bookrentalapp.db.mapper.BookStatusMapper;
import com.butlert.bookrentalapp.db.repository.BookStatusRepository;
import com.butlert.bookrentalapp.dto.BookStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookStatusDAOImp implements BookStatusDAO {

    @Autowired
    private BookStatusRepository bookStatusRepository;


    @Override
    public List<BookStatusDTO> findAllBookStatuses() {
        return bookStatusRepository.findAll()
                .stream().map(BookStatusMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public BookStatusDTO findBookStatusById(Long id) {
        System.out.println("Received ID: " + id);
        return bookStatusRepository.findById(id)
                .map(BookStatusMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Book Status not found"));
    }

    @Override
    public BookStatusDTO saveBookStatus(BookStatus bookStatus) {
        BookStatus savedBookStatus = bookStatusRepository.save(bookStatus);
        return BookStatusMapper.toDTO(savedBookStatus);
    }
}
