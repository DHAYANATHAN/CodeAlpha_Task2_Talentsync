package com.talentsync.talentsync.repository;

import com.talentsync.talentsync.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    Optional<User> findById(Long id);
    Optional<User> findByEmailAndPassword(String email, String password);
}