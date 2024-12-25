package com.butlert.bookrentalapp.db.repository;

import com.butlert.bookrentalapp.db.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
}
