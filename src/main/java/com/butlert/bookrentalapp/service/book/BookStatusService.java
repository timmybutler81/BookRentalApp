package com.butlert.bookrentalapp.service.book;

import com.butlert.bookrentalapp.db.entity.book.BookStatus;
import com.butlert.bookrentalapp.db.mapper.book.BookStatusMapper;
import com.butlert.bookrentalapp.db.repository.book.BookStatusRepository;
import com.butlert.bookrentalapp.dto.book.BookStatusDTO;
import com.butlert.bookrentalapp.validator.ValidatorImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookStatusService {

    @Autowired
    private BookStatusRepository bookStatusRepository;

    @Autowired
    private ValidatorImp validator;

    private static final Logger logger = LoggerFactory.getLogger(BookStatusService.class);

    public BookStatusDTO saveBookStatus(BookStatusDTO bookStatusDTO) {
        validator.validate(bookStatusDTO);
        BookStatus savedBookStatus = bookStatusRepository.save(BookStatusMapper.toEntity(bookStatusDTO));
        return BookStatusMapper.toDTO(savedBookStatus);
    }

    public BookStatusDTO findBookStatusById(Long id) {
            return bookStatusRepository.findById(id)
                    .map(BookStatusMapper::toDTO)
                    .orElseThrow(() -> {
                        logger.warn("Book Status not found with ID : {}", id);
                        return new RuntimeException("Book Status not found with ID: " + id);
                    });
    }

    public List<BookStatusDTO> findAllBookStatuses() {
        return bookStatusRepository.findAll()
                .stream()
                .map(BookStatusMapper::toDTO)
                .collect(Collectors.toList());
    }
}
