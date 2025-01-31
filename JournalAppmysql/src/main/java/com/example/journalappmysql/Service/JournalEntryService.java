package com.example.journalappmysql.Service;

import com.example.journalappmysql.Entity.JournalEntry;
import com.example.journalappmysql.Repositry.JournalEntryRepositry;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JournalEntryService {
    @Autowired
    private JournalEntryRepositry journalEntryRepositry;

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepositry.save(journalEntry);
    }

    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryRepositry.findAll();
    }

    public Optional<JournalEntry> findJournalEntryById(Long id) {
        return journalEntryRepositry.findById(id);
    }

    public void deleteJournalEntryById(Long id) {
        journalEntryRepositry.deleteById(id);
    }
}