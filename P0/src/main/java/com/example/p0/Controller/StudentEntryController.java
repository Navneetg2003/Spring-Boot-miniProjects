package com.example.p0.Controller;

import com.example.p0.Entity.StudentEntry;
import com.example.p0.Repository.StudentEntryRepository;
import com.example.p0.Service.StudentEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entry")
public class StudentEntryController {

    @Autowired
    private StudentEntryService studentEntryService;

    @GetMapping("/getall")
    public List<StudentEntry> getAllStudentEntry(){
        return studentEntryService.findAll();
    }

    @PostMapping("/add")
    public StudentEntry addStudentEntry(@RequestBody StudentEntry studentEntry){
        studentEntryService.save(studentEntry);
        return studentEntry;
    }

    @GetMapping("/id/{myid}")
    public StudentEntry getStudentEntryById(@PathVariable int myid){
        Optional<StudentEntry> studentEntry = studentEntryService.findById(myid);
        if (studentEntry.isPresent()) {
            return studentEntry.get();
        } else {
            throw new RuntimeException("StudentEntry not found for id: " + myid);  // Or return an appropriate response
        }
    }

    @DeleteMapping("/id/{myid}")
    public String deleteStudentEntryById(@PathVariable int myid){
        studentEntryService.deleteById(myid);
        return "Successfully deleted";
    }

}
