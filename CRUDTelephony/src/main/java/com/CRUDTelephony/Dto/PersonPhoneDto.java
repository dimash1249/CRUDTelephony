package com.CRUDTelephony.Dto;

import lombok.Data;

@Data
public class PersonPhoneDto {
    private int id;
    private String name;
    private int birthYear;
    private String phoneFirst;
    private String phoneSecond;
}
