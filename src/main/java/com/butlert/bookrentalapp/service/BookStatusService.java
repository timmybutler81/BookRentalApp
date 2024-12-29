package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.BookStatusDAO;
import com.butlert.bookrentalapp.db.entity.BookStatus;
import com.butlert.bookrentalapp.db.mapper.BookStatusMapper;
import com.butlert.bookrentalapp.dto.BookStatusDTO;
import com.butlert.bookrentalapp.validator.ValidatorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStatusService {

    @Autowired
    private ValidatorImp validatorImp;

    @Autowired
    private BookStatusDAO bookStatusDAO;

    public List<BookStatusDTO> getAllBookStatuses() {
        return bookStatusDAO.findAllBookStatuses();
    }

    public BookStatusDTO getBookStatusById(Long id) {
        return bookStatusDAO.findBookStatusById(id);
    }

    public BookStatusDTO saveBookStatus(BookStatusDTO bookStatusDTO) {
        validatorImp.validate(bookStatusDTO);
        BookStatus bookStatus = BookStatusMapper.toEntity(bookStatusDTO);
        return bookStatusDAO.saveBookStatus(bookStatus);
    }
}
