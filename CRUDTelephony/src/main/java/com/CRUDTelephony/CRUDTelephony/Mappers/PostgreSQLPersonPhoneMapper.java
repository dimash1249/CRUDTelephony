package com.CRUDTelephony.CRUDTelephony.Mappers;

import com.CRUDTelephony.CRUDTelephony.Dto.PostgreSQLPersonPhoneDto;
import com.CRUDTelephony.CRUDTelephony.Models.PostgreSQLPersonPhone;

public class PostgreSQLPersonPhoneMapper {

    public static PostgreSQLPersonPhoneDto mapToPersonPhoneDto(PostgreSQLPersonPhone postgreSQLPersonPhone) {
        PostgreSQLPersonPhoneDto postgreSQLPersonPhoneDto = new PostgreSQLPersonPhoneDto(
                postgreSQLPersonPhone.getId(),
                postgreSQLPersonPhone.getName(),
                postgreSQLPersonPhone.getBirthYear(),
                postgreSQLPersonPhone.getPhoneFirst(),
                postgreSQLPersonPhone.getPhoneSecond(),
                postgreSQLPersonPhone.getCreationDate()
        );
        return postgreSQLPersonPhoneDto;
    }

    public static PostgreSQLPersonPhone mapToPersonPhone(PostgreSQLPersonPhoneDto postgreSQLPersonPhoneDto) {
        return new PostgreSQLPersonPhone(
                postgreSQLPersonPhoneDto.getId(),
                postgreSQLPersonPhoneDto.getName(),
                postgreSQLPersonPhoneDto.getBirthYear(),
                postgreSQLPersonPhoneDto.getPhoneFirst(),
                postgreSQLPersonPhoneDto.getPhoneSecond(),
                postgreSQLPersonPhoneDto.getCreationDate()
        );
    }
}
