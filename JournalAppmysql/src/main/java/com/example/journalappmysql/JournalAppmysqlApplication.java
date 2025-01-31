package com.example.journalappmysql;

import com.example.journalappmysql.Entity.JournalEntry;
import com.example.journalappmysql.Repositry.JournalEntryRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JournalAppmysqlApplication {

    @Autowired
    private static JournalEntryRepositry journalEntryRepositry;


    public static void main(String[] args) {
        SpringApplication.run(JournalAppmysqlApplication.class, args);

//        JournalEntry journalEntry = new JournalEntry();
//
//        journalEntry.setTitle("Title");
//        journalEntry.setContent("Content");
//
//
//        System.out.println("Check"+journalEntry.getContent());
//

    }

}
