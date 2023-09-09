package com.CRUDTelephony.Mappers;

import com.CRUDTelephony.Dto.PersonPhoneDto;
import com.CRUDTelephony.Models.PersonPhone;

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
        PersonPhone personPhone = new PersonPhone(
                personPhoneDto.getId(),
                personPhoneDto.getName(),
                personPhoneDto.getBirthYear(),
                personPhoneDto.getPhoneFirst(),
                personPhoneDto.getPhoneSecond(),
                personPhoneDto.getCreationDate()
        );
        return personPhone;
    }
}
