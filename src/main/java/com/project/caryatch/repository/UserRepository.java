package com.project.caryatch.repository;

import com.project.caryatch.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
