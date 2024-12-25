package com.butlert.bookrentalapp.db.repository;

import com.butlert.bookrentalapp.db.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

}
