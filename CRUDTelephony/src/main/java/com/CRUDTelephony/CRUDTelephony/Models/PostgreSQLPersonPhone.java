package com.CRUDTelephony.CRUDTelephony.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "person_phones")
public class PostgreSQLPersonPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;

    @Column(name = "person_name")
    private String name;

    @Column(name = "person_birth_year")
    private int birthYear;

    @Column(name = "person_phone_first")
    private String phoneFirst;

    @Column(name = "person_phone_second")
    private String phoneSecond;

    @Column(name = "person_creation_date")
    private Date creationDate;

    public PostgreSQLPersonPhone(){

    }

    public PostgreSQLPersonPhone(int id, String name, int birthYear, String phoneFirst, String phoneSecond, Date creationDate) {
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

    @Override
    public String toString() {
        return "PersonPhone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", phoneFirst='" + phoneFirst + '\'' +
                ", phoneSecond='" + phoneSecond + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
