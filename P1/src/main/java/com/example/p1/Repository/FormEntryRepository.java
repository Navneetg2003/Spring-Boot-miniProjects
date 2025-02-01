package com.example.p1.Repository;

import com.example.p1.Entity.FormEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FormEntryRepository extends JpaRepository<FormEntry, Integer> {

}
