package com.myapp.p11_loggin.Controller;


import com.myapp.p11_loggin.Entity.JournalEntry;
import com.myapp.p11_loggin.Service.JournalEntryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/update/{myid}")
    public ResponseEntity<String> updateJournalEntry(@PathVariable Long myid, @RequestBody JournalEntry journalEntry) {
        Optional<JournalEntry> existingEntryOpt = journalEntryService.findJournalEntryById(myid);

        if (existingEntryOpt.isPresent()) {
            JournalEntry existingEntry = existingEntryOpt.get();
            existingEntry.setTitle(journalEntry.getTitle());
            existingEntry.setContent(journalEntry.getContent());
            journalEntryService.UpdateJournalEntry(existingEntry);
            return ResponseEntity.ok("Journal entry updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Journal entry not found with ID: " + myid);
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
