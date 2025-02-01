package com.example.p0.Repository;

import com.example.p0.Entity.StudentEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentEntryRepository extends JpaRepository<StudentEntry, Integer> {

    // Native SQL query to get all student entries
    @Query(value = "SELECT * FROM student", nativeQuery = true)
    List<StudentEntry> findAllStudentEntries();

    // Native SQL query to get a student entry by ID
    @Query(value = "SELECT * FROM student WHERE id = ?1 ", nativeQuery = true)
    Optional<StudentEntry> findStudentEntryById(Integer myid);

    // Native SQL query to delete a student entry by ID
    @Query(value = "DELETE FROM student WHERE id = :myid", nativeQuery = true)
    void deleteStudentEntryById(@Param("myid") int myid);

    @Query(value = "SELECT * FROM student WHERE name = ?1", nativeQuery = true)
    Optional<StudentEntry> findStudentEntryByName(String myname);

}
