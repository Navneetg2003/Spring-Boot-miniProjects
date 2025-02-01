package com.example.p0.Service;

import com.example.p0.Entity.StudentEntry;
import com.example.p0.Repository.StudentEntryRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentEntryServiceTest {
    @Autowired
    private StudentEntryService studentEntryService;

//    @ParameterizedTest
//    @CsvSource({
//            "ram",
//            "shyam",
//            "Nav"
//    })
    @ParameterizedTest
    @ArgumentsSource(UsersArgumentProvider.class)
    public void testFindByName(StudentEntry studentEntry) {
        studentEntryService.save(studentEntry);
        Optional<StudentEntry> foundStudent = studentEntryService.findByName(studentEntry.getName());
        assertTrue(foundStudent.isPresent(), "The student with name " + studentEntry.getName() + " should be found.");
    }



//    @ParameterizedTest
//    @CsvSource({
//            "1,1,2",
//            "2,10,12",
//            "3,3,9"
//    })
//    public void test(int a,int b, int c){
//        assertEquals(c, a + b);
//    }
}