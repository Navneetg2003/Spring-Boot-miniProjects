package com.example.p1.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "form")
public class FormEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String gender;
    private String age;
    private String mailId;



    public FormEntry(int id, String name, String gender, String age, String mailId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.mailId = mailId;
    }

    public FormEntry() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "FormEntry{" +
                "mailId='" + mailId + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
