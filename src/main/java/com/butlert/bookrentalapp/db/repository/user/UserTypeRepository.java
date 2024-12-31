package com.butlert.bookrentalapp.db.repository.user;

import com.butlert.bookrentalapp.db.entity.user.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
    @Query(value = "SELECT rental_duration_days FROM user_type WHERE user_type_id = :userId;", nativeQuery = true)
    int findCheckoutDurationByUserTypeId(@Param("userId") Long id);
}
