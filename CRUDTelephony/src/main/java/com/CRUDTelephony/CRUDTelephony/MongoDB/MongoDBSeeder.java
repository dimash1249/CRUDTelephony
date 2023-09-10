package com.CRUDTelephony.CRUDTelephony.MongoDB;

import com.CRUDTelephony.CRUDTelephony.Models.MongoDBPersonPhone;
import com.CRUDTelephony.CRUDTelephony.Repositories.MongoDBPersonPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MongoDBSeeder {
    private final MongoDBPersonPhoneRepository mongoDBPersonPhoneRepository;

    @Autowired
    public MongoDBSeeder(MongoDBPersonPhoneRepository personPhoneRepository) {
        this.mongoDBPersonPhoneRepository = personPhoneRepository;
    }

    public void seedData() {
        for(int i=0;i<5;i++) {
            MongoDBPersonPhone mongoDBPersonPhone = new MongoDBPersonPhone();
            mongoDBPersonPhone.setName("Dimash" + (i+1));
            mongoDBPersonPhone.setBirthYear(2001 + i);
            mongoDBPersonPhone.setPhoneFirst("+7747333421" + (5 + i));
            mongoDBPersonPhone.setPhoneSecond("+774733342" + (15 + (i * 12)));
            mongoDBPersonPhone.setCreationDate(new Date());
            mongoDBPersonPhoneRepository.save(mongoDBPersonPhone);
        }
    }
}
