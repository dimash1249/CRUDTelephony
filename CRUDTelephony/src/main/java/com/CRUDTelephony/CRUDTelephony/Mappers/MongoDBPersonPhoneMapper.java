package com.CRUDTelephony.CRUDTelephony.Mappers;

import com.CRUDTelephony.CRUDTelephony.Dto.MongoDBPersonPhoneDto;
import com.CRUDTelephony.CRUDTelephony.Models.MongoDBPersonPhone;

public class MongoDBPersonPhoneMapper {

    public static MongoDBPersonPhoneDto mapToPersonPhoneDto(MongoDBPersonPhone mongoDBPersonPhone) {
        return new MongoDBPersonPhoneDto(
                mongoDBPersonPhone.getId(),
                mongoDBPersonPhone.getName(),
                mongoDBPersonPhone.getBirthYear(),
                mongoDBPersonPhone.getPhoneFirst(),
                mongoDBPersonPhone.getPhoneSecond(),
                mongoDBPersonPhone.getCreationDate()
        );
    }

    public static MongoDBPersonPhone mapToPersonPhone(MongoDBPersonPhoneDto mongoDBPersonPhoneDto) {
        return new MongoDBPersonPhone(
                mongoDBPersonPhoneDto.getId(),
                mongoDBPersonPhoneDto.getName(),
                mongoDBPersonPhoneDto.getBirthYear(),
                mongoDBPersonPhoneDto.getPhoneFirst(),
                mongoDBPersonPhoneDto.getPhoneSecond(),
                mongoDBPersonPhoneDto.getCreationDate()
        );
    }
}
