package com.CRUDTelephony.CRUDTelephony.Mappers;

import com.CRUDTelephony.CRUDTelephony.Dto.PersonPhoneDto;
import com.CRUDTelephony.CRUDTelephony.Models.PersonPhone;

public class PersonPhoneMapper {

    public static PersonPhoneDto mapToPersonPhoneDto(PersonPhone personPhone) {
        PersonPhoneDto personPhoneDto = new PersonPhoneDto(
                personPhone.getId(),
                personPhone.getName(),
                personPhone.getBirthYear(),
                personPhone.getPhoneFirst(),
                personPhone.getPhoneSecond(),
                personPhone.getCreationDate()
        );
        return personPhoneDto;
    }

    public static PersonPhone mapToPersonPhone(PersonPhoneDto personPhoneDto) {
        return new PersonPhone(
                personPhoneDto.getId(),
                personPhoneDto.getName(),
                personPhoneDto.getBirthYear(),
                personPhoneDto.getPhoneFirst(),
                personPhoneDto.getPhoneSecond(),
                personPhoneDto.getCreationDate()
        );
    }
}
