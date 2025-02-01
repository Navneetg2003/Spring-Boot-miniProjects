package com.example.p2.Repository;

import com.example.p2.Entity.SignUpEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpEntry, Long> {
    SignUpEntry findByEmail(String Email);
    boolean existsByEmail(String email);
}
