package com.example.p1.Service;

import com.example.p1.Entity.FormEntry;
import com.example.p1.Repository.FormEntryRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormEntryService {

    @Autowired
    private FormEntryRepository formEntryRepository;

    @Autowired
    private EmailService emailService;

    public void saveFormEntry(FormEntry formEntry) throws MessagingException {
        formEntryRepository.save(formEntry);
    }

    public List<FormEntry> getAll() {
        return formEntryRepository.findAll();
    }

    public Optional<FormEntry> getById(int id) {
        return formEntryRepository.findById(id);
    }

    public void deleteById(int id){
        formEntryRepository.deleteById(id);
    }
}
