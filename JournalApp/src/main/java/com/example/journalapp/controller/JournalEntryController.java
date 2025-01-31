//package com.example.journalapp.controller;
//
//import com.example.journalapp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
//    private long nextId = 1;
//
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public boolean CreateEntry(@RequestBody JournalEntry myEntry){
//        myEntry.setId(nextId++);
//        journalEntries.put(myEntry.getId(), myEntry);
//        return true;
//    }
//
//    @GetMapping("id/{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable long myId){
//        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping("id/{myId}")
//    public boolean deleteJournalEntryById(@PathVariable long myId){
//        journalEntries.remove(myId);
//        return true;
//    }
//
//    @PutMapping("id/{myId}")
//    public boolean updateJournalEntryById(@PathVariable long myId, @RequestBody JournalEntry myEntry){
//        journalEntries.put(myId, myEntry);
//        return true;
//    }
//}
