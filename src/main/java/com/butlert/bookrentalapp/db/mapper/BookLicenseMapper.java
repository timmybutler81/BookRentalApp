package com.butlert.bookrentalapp.db.mapper;

import com.butlert.bookrentalapp.db.entity.Book;
import com.butlert.bookrentalapp.db.entity.BookLicense;
import com.butlert.bookrentalapp.db.entity.BookStatus;
import com.butlert.bookrentalapp.dto.BookDTO;
import com.butlert.bookrentalapp.dto.BookLicenseDTO;

public class BookLicenseMapper {

    public static BookLicenseDTO toDTO(BookLicense bookLicense) {
        BookDTO bookDTO = new BookDTO(
                bookLicense.getBook().getId(),
                bookLicense.getBook().getGenre(),
                bookLicense.getBook().getTitle(),
                bookLicense.getBook().getAuthor(),
                bookLicense.getBook().getIsbn(),
                bookLicense.getBook().getPublisher(),
                bookLicense.getBook().getPublishYear(),
                bookLicense.getBook().isActiveFlag()
        );
        return new BookLicenseDTO(
                bookLicense.getId(),
                bookDTO,
                bookLicense.getBookStatus(),
                bookLicense.getBookStatus() != null ? bookLicense.getBookStatus().getId() : null, // Explicitly set bookStatusId
                bookLicense.getLicenseKey(),
                bookLicense.isActiveFlag(),
                bookLicense.isAvailable()
        );
    }

    public static BookLicense toEntity(BookLicenseDTO bookLicenseDTO) {
        Book book = new Book();
        book.setId(bookLicenseDTO.getBook().getId());
        book.setGenre(bookLicenseDTO.getBook().getGenre());
        book.setTitle(bookLicenseDTO.getBook().getTitle());
        book.setAuthor(bookLicenseDTO.getBook().getAuthor());
        book.setIsbn(bookLicenseDTO.getBook().getIsbn());
        book.setPublisher(bookLicenseDTO.getBook().getPublisher());
        book.setPublishYear(bookLicenseDTO.getBook().getPublishYear());
        book.setActiveFlag(bookLicenseDTO.getBook().isActiveFlag());

        BookLicense bookLicense = new BookLicense();
        bookLicense.setId(bookLicenseDTO.getId());
        bookLicense.setBook(book);

        if (bookLicenseDTO.getBookStatusId() != null) {
            BookStatus bookStatus = new BookStatus();
            bookStatus.setId(bookLicenseDTO.getBookStatusId());
            bookLicense.setBookStatus(bookStatus);
        }

        bookLicense.setLicenseKey(bookLicenseDTO.getLicenseKey());
        bookLicense.setActiveFlag(bookLicenseDTO.isActiveFlag());
        return bookLicense;
    }
}
