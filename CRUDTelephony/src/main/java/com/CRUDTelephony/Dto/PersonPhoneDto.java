package com.CRUDTelephony.Dto;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@Getter
public class PersonPhoneDto {
    private int id;
    private String name;
    private int birthYear;
    private String phoneFirst;
    private String phoneSecond;
    private Date creationDate;

    public PersonPhoneDto(int id, String name, int birthYear, String phoneFirst, String phoneSecond, Date creationDate) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.phoneFirst = phoneFirst;
        this.phoneSecond = phoneSecond;
        this.creationDate = creationDate;
    }
}
