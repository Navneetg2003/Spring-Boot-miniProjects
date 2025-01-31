package com.example.journalappmysql.Repositry;

import com.example.journalappmysql.Entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepositry extends JpaRepository<JournalEntry, Long> {

}
