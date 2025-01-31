package com.example.journalappmysql.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "enteries")
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    // Default constructor (required by JPA)
    public JournalEntry() {
    }

    // Constructor with all fields
    public JournalEntry(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "JournalEntry{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
