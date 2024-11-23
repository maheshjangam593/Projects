package com.example.repository;

import com.example.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserCredential, Integer> {

    Optional<UserCredential> findByName(String username);


}
