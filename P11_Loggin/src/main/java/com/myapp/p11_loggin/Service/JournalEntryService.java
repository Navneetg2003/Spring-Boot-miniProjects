package com.myapp.p11_loggin.Service;

import com.myapp.p11_loggin.Entity.JournalEntry;
import com.myapp.p11_loggin.Repository.JournalEntryRepositry;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class JournalEntryService {
    @Autowired
    private JournalEntryRepositry journalEntryRepositry;

    public void saveEntry(JournalEntry journalEntry) {
        try {
            journalEntryRepositry.save(journalEntry);
            log.info("****SUCCESS****");
        }catch (Exception e) {
            log.error("****ERROR****");
            log.warn("****WARN****");
            log.debug("****DEBUG****");
            log.trace("****TRACE****");
        }
    }

    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryRepositry.findAll();
    }

    public Optional<JournalEntry> findJournalEntryById(Long id) {
        return journalEntryRepositry.findById(id);
    }

    public void UpdateJournalEntry(JournalEntry journalEntry) {
        try {
            journalEntryRepositry.save(journalEntry);
            log.info("Successfully saved/updated journal entry with ID: {}", journalEntry.getId());
        } catch (Exception e) {
            log.error("Error saving/updating journal entry with ID: {}", journalEntry.getId(), e);
        }
    }

    public void deleteJournalEntryById(Long id) {
        journalEntryRepositry.deleteById(id);
    }
}