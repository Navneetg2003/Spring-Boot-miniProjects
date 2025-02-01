package com.myapp.p11_loggin.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Setter
@Getter
@Entity
@RevisionEntity
public class CustomRevisionEntity {

    @Id
    @RevisionNumber
    private int id;

    @RevisionTimestamp
    private long timestamp;

    // Add a field to store the operation type as a string
    private String operationType;

}
