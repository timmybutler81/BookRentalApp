package com.butlert.bookrentalapp.db.repository;

import com.butlert.bookrentalapp.db.entity.TransactionType;
import com.butlert.bookrentalapp.dto.TransactionTypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
    Optional<TransactionType> findByTransactionTypeName(String transactionTypeName);
}
