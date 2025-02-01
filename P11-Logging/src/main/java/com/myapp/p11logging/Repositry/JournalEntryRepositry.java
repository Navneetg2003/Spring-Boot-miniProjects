package com.myapp.p11logging.Repositry;

import com.myapp.p11logging.Entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepositry extends JpaRepository<JournalEntry, Long> {

}
