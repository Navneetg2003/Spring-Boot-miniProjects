package com.myapp.p11_loggin.Repository;

import com.myapp.p11_loggin.Entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepositry extends JpaRepository<JournalEntry, Long> {

}
