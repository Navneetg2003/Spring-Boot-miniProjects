package com.example.journalappmysql.Service;

import com.example.journalappmysql.Entity.JournalEntry;
import com.example.journalappmysql.Repositry.JournalEntryRepositry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JournalEntryServiceTest {
    @Mock
    JournalEntryRepositry journalEntryRepositry;

    @InjectMocks
    JournalEntryService journalEntryService;

    @Test
    void saveJournalEntryShouldSaveEntrySuccessfully() {
        JournalEntry je = new JournalEntry();
        Mockito.when(journalEntryRepositry.save(je)).thenReturn(je);

        // Call the method (it returns void, so no need to capture the return value)
        journalEntryService.saveEntry(je);

        // Verify that the save method was called on the repository
        Mockito.verify(journalEntryRepositry, Mockito.times(1)).save(je);

        System.out.println("my first unit test");
    }

  
}