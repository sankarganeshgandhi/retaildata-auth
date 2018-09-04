package com.sgglabs.retail.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * CREATE TABLE Status(
 *     Id INT(2) NOT NULL AUTO_INCREMENT,
 *     Description VARCHAR(30) NOT NULL,
 *     CreatedDate DATE,
 *     ModifiedDate DATE,
 *     PRIMARY KEY (Id)
 * );
 */
@Entity(name = "Status")
@Table(name = "Status")
public class Status {
    private static final Logger LOG = LoggerFactory.getLogger(Status.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Description")
    private String userName;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "ModifiedDate")
    private LocalDate modifiedDate;

    public Status() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(id, status.id) &&
                Objects.equals(userName, status.userName) &&
                Objects.equals(createdDate, status.createdDate) &&
                Objects.equals(modifiedDate, status.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, createdDate, modifiedDate);
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}