package com.example.p4security.Repo;

import com.example.p4security.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);

    @Query(value = "SELECT * FROM users where username = ?1;",nativeQuery = true)
    Optional<Users> findBytheUsername(String username);
}
