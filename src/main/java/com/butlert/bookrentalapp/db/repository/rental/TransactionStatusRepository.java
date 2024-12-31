package com.butlert.bookrentalapp.db.repository.rental;

import com.butlert.bookrentalapp.db.entity.rental.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionStatusRepository extends JpaRepository<TransactionStatus, Long> {
}
