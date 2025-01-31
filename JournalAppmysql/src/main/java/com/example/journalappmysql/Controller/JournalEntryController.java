package com.example.journalappmysql.Controller;


import com.example.journalappmysql.Entity.JournalEntry;
import com.example.journalappmysql.Service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class JournalEntryController {


    @Autowired
    private JournalEntryService journalEntryService;

    @PostMapping("/create")
    public JournalEntry createJournalEntry(@RequestBody JournalEntry journalEntry) {
        journalEntryService.saveEntry(journalEntry);
        return journalEntry;
    }

    @GetMapping("/getall")
    public List<JournalEntry> getAllJournalEntry() {
        return journalEntryService.getAllJournalEntries();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable Long id) {
        Optional<JournalEntry> journalEntry = journalEntryService.findJournalEntryById(id);
        if (journalEntry.isPresent()) {
            return ResponseEntity.ok(journalEntry.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJournalEntry(@PathVariable Long id) {
        Optional<JournalEntry> journalEntry = journalEntryService.findJournalEntryById(id);
        if (journalEntry.isPresent()) {
            journalEntryService.deleteJournalEntryById(id);
            return ResponseEntity.ok("Successfully deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
