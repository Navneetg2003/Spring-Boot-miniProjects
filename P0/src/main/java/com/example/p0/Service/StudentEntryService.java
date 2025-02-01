package com.example.p0.Service;

import com.example.p0.Entity.StudentEntry;
import com.example.p0.Repository.StudentEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentEntryService {

    @Autowired
    private StudentEntryRepository studentEntryRepository;

    public List<StudentEntry> findAll() {
        return studentEntryRepository.findAllStudentEntries();
    }

    public Optional<StudentEntry> findById(int id) {
        return studentEntryRepository.findStudentEntryById(id);
    }

    public Optional<StudentEntry> findByName(String name) {
        return studentEntryRepository.findStudentEntryByName(name);
    }

    public boolean save(StudentEntry studentEntry) {
        try {
            studentEntryRepository.save(studentEntry);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void deleteById(int id) {
        studentEntryRepository.deleteStudentEntryById(id);
    }
}
