package com.example.journalapp.service;

import com.example.journalapp.entity.JournalEntry;
import com.example.journalapp.repositry.JournalEntryRepositry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepositry journalEntryRepositry;

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepositry.save(journalEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepositry.findAll();
    }

    public Optional<JournalEntry> getById(ObjectId id){
        return journalEntryRepositry.findById(id);
    }

    public void deleteById(ObjectId id) {
        journalEntryRepositry.deleteById(id);
    }
}
