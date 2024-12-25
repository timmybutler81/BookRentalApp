package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> findBookByTitleKeyword(String keyword) {
        String sql = "SELECT * FROM Book WHERE title LIKE ?1";
        Query query = entityManager.createNativeQuery(sql, Book.class);
        query.setParameter(1, "%" + keyword + "%");
        return query.getResultList();
    }
}
