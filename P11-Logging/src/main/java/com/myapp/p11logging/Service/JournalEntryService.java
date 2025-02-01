package com.myapp.p11logging.Service;

import com.myapp.p11logging.Entity.JournalEntry;
import com.myapp.p11logging.Repositry.JournalEntryRepositry;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

//    private static final Logger logger= LoggerFactory.getLogger(JournalEntryService.class);

    public void saveEntry(JournalEntry journalEntry) {
       try {
           journalEntryRepositry.save(journalEntry);
           log.info("****SUCCESS SAVE ENTRY ****");
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

    public void deleteJournalEntryById(Long id) {
        journalEntryRepositry.deleteById(id);
    }
}