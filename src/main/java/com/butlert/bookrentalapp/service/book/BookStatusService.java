package com.butlert.bookrentalapp.service.book;

import com.butlert.bookrentalapp.dao.book.BookStatusDAO;
import com.butlert.bookrentalapp.dto.book.BookStatusDTO;
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

    public BookStatusDTO addOrUpdateBookStatus(BookStatusDTO bookStatusDTO) {
        validatorImp.validate(bookStatusDTO);
        return bookStatusDAO.saveBookStatus(bookStatusDTO);
    }

    public BookStatusDTO getBookStatusById(Long id) {
        return bookStatusDAO.findBookStatusById(id);
    }

    public List<BookStatusDTO> getAllBookStatuses() {
        return bookStatusDAO.findAllBookStatuses();
    }
}
