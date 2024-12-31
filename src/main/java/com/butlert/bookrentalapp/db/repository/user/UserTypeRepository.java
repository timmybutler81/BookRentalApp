package com.butlert.bookrentalapp.db.repository.user;

import com.butlert.bookrentalapp.db.entity.user.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

}
