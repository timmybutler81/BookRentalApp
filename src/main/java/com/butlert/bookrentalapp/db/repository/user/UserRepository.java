package com.butlert.bookrentalapp.db.repository.user;

import com.butlert.bookrentalapp.db.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAddress(String emailAddress);

    Optional<User> findByLastName(String lastName);
}
