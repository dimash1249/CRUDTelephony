package com.CRUDTelephony.CRUDTelephony.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostgreSQLPersonPhoneDto {
    private int id;
    private String name;
    private int birthYear;
    private String phoneFirst;
    private String phoneSecond;
    private Date creationDate;

    public PostgreSQLPersonPhoneDto(int id, String name, int birthYear, String phoneFirst, String phoneSecond, Date creationDate) {
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

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getPhoneFirst() {
        return phoneFirst;
    }

    public String getPhoneSecond() {
        return phoneSecond;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
