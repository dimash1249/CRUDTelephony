package com.CRUDTelephony.CRUDTelephony.Models;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "PersonPhones")
public class MongoDBPersonPhone {
    @Id
    private int id;
    private String name;
    private int birthYear;
    private String phoneFirst;
    private String phoneSecond;
    private Date creationDate;

    public MongoDBPersonPhone() {
    }

    public MongoDBPersonPhone(int id, String name, int birthYear, String phoneFirst, String phoneSecond, Date creationDate) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.phoneFirst = phoneFirst;
        this.phoneSecond = phoneSecond;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getPhoneFirst() {
        return phoneFirst;
    }

    public void setPhoneFirst(String phoneFirst) {
        this.phoneFirst = phoneFirst;
    }

    public String getPhoneSecond() {
        return phoneSecond;
    }

    public void setPhoneSecond(String phoneSecond) {
        this.phoneSecond = phoneSecond;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
