package com.CRUDTelephony.CRUDTelephony;

import com.CRUDTelephony.CRUDTelephony.Models.MongoDBPersonPhone;
import com.CRUDTelephony.CRUDTelephony.Repositories.MongoDBPersonPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;


@SpringBootApplication
public class CrudTelephonyApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudTelephonyApplication.class, args);
	}

}
